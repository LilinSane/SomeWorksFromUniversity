import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Point {
  x: number;
  y: number;
  r: number;
  hit?: boolean;
  workTime?: number;
  currTime?: string;
  email?: string;
}
@Injectable({providedIn: 'root'})
export class PointsService{
  constructor(private http : HttpClient) {
  }

  sendPoint(point : Point) : Observable<Point>{
    return this.http.post<Point>('http://localhost:8080/point', point);
  }

  fetchPoints(email : string) : Observable<Point[]>{
    return this.http.post<Point[]>('http://localhost:8080/get',email);
  }

  deletePoints(email : string){
    return this.http.post<void>('http://localhost:8080/delete',email);
  }
}
