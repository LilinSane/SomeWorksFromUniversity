import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface User{
  email: string;
  password: string;
}

@Injectable({providedIn : "root"})
export class AuthService{
  isAuth = false
  constructor(private http: HttpClient) {
  }
  login(user: User) : Observable<boolean>{
    return this.http.post<boolean>('http://localhost:8080/login', user);
  }

  logout(){
    this.isAuth = false;
    localStorage.removeItem('isUserLoggedIn');
  }
  register(user: User){
    return this.http.post<boolean>('http://localhost:8080/register', user);
  }



}
