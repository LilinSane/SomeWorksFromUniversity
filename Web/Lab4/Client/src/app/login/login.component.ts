import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-start',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  email : string;
  password: string;

  constructor(private authService: AuthService, private router : Router) {

  }

  isAuthorize(){
    if(JSON.parse(localStorage.getItem('isUserLoggedIn')) == true){
      this.router.navigate(['/main']);
    }
  }
  ngOnInit(): void {
    this.isAuthorize();
    console.log(this.authService.isAuth);
  }

  onLogin(){
    this.isAuthorize();
    const user = {
      email: this.email,
      password: this.password
    }
    this.authService.login(user).subscribe(isAuth =>{
        this.authService.isAuth = isAuth;
        localStorage.setItem('isUserLoggedIn', this.authService.isAuth ? "true" : "false");
        if(isAuth){
          this.router.navigate(['/main']);
          localStorage.setItem('userName', this.email);
        }
      })
  }

  onLogout(){
    this.authService.logout();
  }

}
