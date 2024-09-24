import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CanvasService{
  MAX_WIDTH : number = 300
  MIN_WIDTH : number = 0
  MAX_HEIGHT : number = 150
  MIN_HEIGHT : number = 0
  MAX_DIVISION : number = 6
  DIVISION_SIZE : number = 10

  draw_def_axis_y() : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext('2d');

    //print line
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT - 10);
    ctx.closePath();
    ctx.stroke();

    //print + division
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MIN_HEIGHT + 15);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MIN_HEIGHT + 15);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R", this.MAX_WIDTH/2 - 30, this.MIN_HEIGHT + 15);

    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MAX_HEIGHT/4 + 5);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MAX_HEIGHT/4 + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R/2", this.MAX_WIDTH/2 - 30, this.MAX_HEIGHT/4 + 5);

    //print - division
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MAX_HEIGHT - 15);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MAX_HEIGHT - 15);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("-R", this.MAX_WIDTH/2 - 30, this.MAX_HEIGHT - 15);

    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, 3*this.MAX_HEIGHT/4 - 5);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, 3*this.MAX_HEIGHT/4 - 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("-R/2", this.MAX_WIDTH/2 - 30, 3*this.MAX_HEIGHT/4 - 5);

    //print arrow
    ctx.fillStyle = "rgba(250, 10, 26, 0.8)";
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2, this.MIN_HEIGHT);
    ctx.lineTo(this.MAX_WIDTH/2 - 5, this.MIN_HEIGHT + 10);
    ctx.fill();

    ctx.fillStyle = "rgba(245, 17, 237, 1)";
    ctx.font = "18px SilafejiraRegular"
    ctx.fillText("Y", this.MAX_WIDTH/2 + 10, this.MIN_HEIGHT + 15);
  }
  draw_def_axis_x() : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext('2d');

    //print line
    ctx.beginPath();
    ctx.moveTo(this.MIN_WIDTH + 85, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2);
    ctx.closePath();
    ctx.stroke();

    //print + division
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH - 90, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(this.MAX_WIDTH - 90, this.MAX_HEIGHT/2 + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R", this.MAX_WIDTH - 90, this.MAX_HEIGHT/2 + 20);

    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/4 + 105, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(this.MAX_WIDTH/4 + 105, this.MAX_HEIGHT/2 + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R/2", this.MAX_WIDTH/4 + 105, this.MAX_HEIGHT/2 + 20);

    //print - division
    ctx.beginPath();
    ctx.moveTo(this.MIN_WIDTH + 90, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(this.MIN_WIDTH + 90, this.MAX_HEIGHT/2 + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R", this.MIN_WIDTH + 90, this.MAX_HEIGHT/2 + 20);

    ctx.beginPath();
    ctx.moveTo(3*this.MAX_WIDTH/4 - 105, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(3*this.MAX_WIDTH/4 - 105, this.MAX_HEIGHT/2 + 5);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "rgba(89, 17, 245, 1)";
    ctx.font = "12px Inkulinati-Regular"
    ctx.fillText("R/2", 3*this.MAX_WIDTH/4 - 105, this.MAX_HEIGHT/2 + 20);

    //print arrow
    ctx.fillStyle = "rgba(250, 10, 26, 0.8)";
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 + 5);
    ctx.lineTo(this.MAX_WIDTH - 75, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 - 5);
    ctx.fill();

    ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
    ctx.font = "18px SilafejiraRegular"
    ctx.fillText("X", this.MAX_WIDTH - 70, this.MAX_HEIGHT/2);
  }

  draw_rectangle(r : number) : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");

    ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
    //ctx.fillRect(3*this.MAX_WIDTH/4 - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE, this.MAX_HEIGHT - 105 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE/2, this.MAX_WIDTH/2 - (3*this.MAX_WIDTH/4 - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE), this.MAX_HEIGHT/2 - (this.MAX_HEIGHT - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE/2) );
    ctx.fillRect(3*this.MAX_WIDTH/4 - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE, this.MAX_HEIGHT - 105 + this.MAX_DIVISION*this.DIVISION_SIZE - 6*this.DIVISION_SIZE/2, this.MAX_WIDTH/2 - (3*this.MAX_WIDTH/4 - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE), this.MAX_HEIGHT/2 - (this.MAX_HEIGHT - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE/2) );
  }

  draw_triangle(r : number){
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");

    ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2, this.MAX_HEIGHT - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE/2);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH/2 + r*this.DIVISION_SIZE/2, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT - 135 + this.MAX_DIVISION*this.DIVISION_SIZE - r*this.DIVISION_SIZE/2);
    ctx.fill();
  }

  draw_circle(r : number) : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");
    if(r < 0){
      ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
      ctx.beginPath();
      ctx.arc(this.MAX_WIDTH/2, this.MAX_HEIGHT/2, Math.abs(r)*this.DIVISION_SIZE/2, Math.PI/2, 0, true);
      ctx.fill();
    }
    else {
      ctx.fillStyle = "rgba(245, 17, 237, 0.5)";
      ctx.beginPath();
      ctx.arc(this.MAX_WIDTH/2, this.MAX_HEIGHT/2, r*this.DIVISION_SIZE/2, Math.PI, 3*Math.PI/2, false);
      ctx.fill();
    }


    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT/2 - r*this.DIVISION_SIZE/2);
    ctx.lineTo(this.MAX_WIDTH/2 - r*this.DIVISION_SIZE/2, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT/2);
    ctx.fill();
  }

  draw_axis_y() : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");

    //print line
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2, this.MAX_HEIGHT - 10);
    ctx.closePath();
    ctx.stroke();

    //print divisions
    for(let i = 0; i <= 12; i++){
      if(i != 6){
        ctx.beginPath();
        ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MAX_HEIGHT - i*this.DIVISION_SIZE - 15);
        ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MAX_HEIGHT - i*this.DIVISION_SIZE - 15);
        ctx.closePath();
        ctx.stroke();
        ctx.fillStyle = "rgba(89, 17, 245, 1)";
        ctx.font = "10px Inkulinati-Regular";
        ctx.fillText(String(i - 6), this.MAX_WIDTH/2 - 15, this.MAX_HEIGHT - i*this.DIVISION_SIZE - 10);
      }
    }

    //print arrow
    ctx.fillStyle = "rgba(255, 0, 0, 1)";
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH/2 - 5, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2 + 5, this.MIN_HEIGHT + 10);
    ctx.lineTo(this.MAX_WIDTH/2, this.MIN_HEIGHT);
    ctx.lineTo(this.MAX_WIDTH/2 - 5, this.MIN_HEIGHT + 10);
    ctx.fill();

    ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
    ctx.font = "18px SilafejiraRegular"
    ctx.fillText("Y", this.MAX_WIDTH/2 + 10, this.MIN_HEIGHT + 15);
  }

  draw_axis_x() : void{
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");

    //print line
    ctx.beginPath();
    ctx.moveTo(this.MIN_WIDTH + 85, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2);
    ctx.closePath();
    ctx.stroke();

    //print divisions
    for(let i = 0; i <= 12; i++){
      if(i != 6){
        ctx.beginPath();
        ctx.moveTo(this.MIN_WIDTH + i*this.DIVISION_SIZE + 90, this.MAX_HEIGHT/2 - 5);
        ctx.lineTo(this.MIN_WIDTH + i*this.DIVISION_SIZE + 90, this.MAX_HEIGHT/2 + 5);
        ctx.closePath();
        ctx.stroke();
        ctx.fillStyle = "rgba(89, 17, 245, 1)";
        ctx.font = "10px Inkulinati-Regular";
        ctx.fillText(String(i - 6), this.MIN_WIDTH + i*this.DIVISION_SIZE + 85,  this.MAX_HEIGHT/2 + 15);
      }
    }


    //print arrow
    ctx.fillStyle = "rgba(250, 10, 26, 1)";
    ctx.beginPath();
    ctx.moveTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 - 5);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 + 5);
    ctx.lineTo(this.MAX_WIDTH - 75, this.MAX_HEIGHT/2);
    ctx.lineTo(this.MAX_WIDTH - 85, this.MAX_HEIGHT/2 - 5);
    ctx.fill();

    ctx.fillStyle = "rgba(245, 17, 237, 0.8)";
    ctx.font = "18px SilafejiraRegular"
    ctx.fillText("X", this.MAX_WIDTH - 75, this.MAX_HEIGHT/2);
  }

  draw_plane(r : number) : void{
    this.draw_axis_x();
    this.draw_axis_y();
    this.draw_triangle(r);
    this.draw_rectangle(r);
    this.draw_circle(r);
  }

  draw_plane_def() : void{
    this.draw_def_axis_x();
    this.draw_def_axis_y();
    this.draw_triangle(5);
    this.draw_rectangle(5);
    this.draw_circle(5);
  }

  clearPlane(){
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");
    ctx.clearRect(0, 0, plane.width, plane.height);
  }

  drawHitCircle(x : number, y : number, hit : boolean){
    let plane = document.getElementById('plane') as HTMLCanvasElement;
    let ctx = plane.getContext("2d");
    if (hit)
      ctx.fillStyle = "#05fa57";
    else
      ctx.fillStyle = "#fa1e38";
    ctx.beginPath();
    ctx.arc(this.MAX_WIDTH / 2 + 10 * x, this.MAX_HEIGHT / 2 - 10 * y, 3, 0, 2 * Math.PI, false);
    ctx.fill();
  }

  calculateCoordinateX(px : number){
    let planeContainer = document.getElementById('plane-container') as HTMLElement;
    let ratioX = this.MAX_WIDTH / planeContainer.clientWidth; //from canv.js
    return ((px * ratioX - this.MAX_WIDTH / 2) / this.DIVISION_SIZE).toFixed(1);
  }

  calculateCoordinateY(px : number){
    let planeContainer = document.getElementById('plane-container') as HTMLElement;
    let ratioY = this.MAX_HEIGHT / planeContainer.clientHeight;
    return ((this.MAX_HEIGHT / 2 - px * ratioY) / this.DIVISION_SIZE).toFixed(1);
  }

  getPlane(){
    return document.getElementById('plane') as HTMLCanvasElement;
  }



}
