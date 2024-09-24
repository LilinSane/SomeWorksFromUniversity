import {Component, OnInit} from '@angular/core';
import {Point, PointsService} from "../services/points.service";
import {CanvasService} from "../services/canvas.service";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {interval} from "rxjs";




@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})


export class MainComponent implements OnInit{
  selectedValueX: string = "0";
  valueY: string ="";
  selectedValueR: string = "0";
  points: Point[] = [];

  isAuthorize(){
    if(localStorage.getItem('isUserLoggedIn') == null){
      this.router.navigate(['/login']);
    }
  }
  ngOnInit(): void {
    const observable = interval(1000);
    observable.subscribe(() => {
      this.getPoints();
    });
  };
  constructor(private pointsService : PointsService, private canvasService : CanvasService, private authService: AuthService, private router: Router) {
  }

  private drawHistory(points : Point[], r : number) : void{
    for (let point of points) {
      if(r == point.r)
        this.canvasService.drawHitCircle(point.x, point.y, point.hit);
    }
  }
  addPointOnPlane(event : MouseEvent) : void{

    let xOff = event.offsetX;
    let yOff = event.offsetY;
    let xBuf = this.selectedValueX;
    this.selectedValueX = this.canvasService.calculateCoordinateX(xOff);
    this.valueY = this.canvasService.calculateCoordinateY(yOff);
    this.addPoint();
    this.selectedValueX = xBuf;
  }
  addPoint() : void{
    this.isAuthorize();
    const newPoint : Point = {
      x: +this.selectedValueX,
      y: +this.valueY,
      r: +this.selectedValueR,
      email: localStorage.getItem("userName")
    }

    this.pointsService.sendPoint(newPoint).subscribe(point =>{
      this.points.push(point);
      console.log(point);
      this.canvasService.drawHitCircle(point.x, point.y, point.hit);
    })
  }

  getPoints() : void{
    this.isAuthorize();
    console.log(localStorage.getItem("userName"));
    this.pointsService.fetchPoints(localStorage.getItem("userName")).subscribe(points => {
      this.points = points;
      this.canvasService.clearPlane();
      this.selectedValueR = localStorage.getItem("r");
      this.canvasService.draw_plane(+localStorage.getItem("r"));
      this.drawHistory(this.points, +localStorage.getItem("r"));
    })
  }

  clearPoints() : void{
    this.isAuthorize();
    this.pointsService.deletePoints(localStorage.getItem("userName")).subscribe(resp => {
      this.points = [];
      this.canvasService.clearPlane();
      this.canvasService.draw_plane(+this.selectedValueR);
      this.resizePlane();
    })
  }

  resizePlane() : void{
    this.isAuthorize();
    localStorage.setItem("r", this.selectedValueR);
    this.canvasService.clearPlane();
    this.canvasService.draw_plane(+this.selectedValueR);
    this.drawHistory(this.points, +this.selectedValueR);
  }

  onLogout(): void{
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}

