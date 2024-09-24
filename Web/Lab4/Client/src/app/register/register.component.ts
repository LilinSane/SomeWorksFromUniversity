import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  email: string;
  password: string;

  constructor(private authService: AuthService, private router : Router) {

  }
  ngOnInit(): void {
    if(this.authService.isAuth == true){
      this.router.navigate(['/main']);
    }
    console.log(this.authService.isAuth);
  }

  onRegister(){
    const user = {
      email: this.email,
      password: this.password
    }
    this.authService.register(user).subscribe(isAuth =>{
      this.authService.isAuth = isAuth;
      localStorage.setItem('isUserLoggedIn', this.authService.isAuth ? "true" : "false");
      if(isAuth){
        this.router.navigate(['/main']);
        localStorage.setItem('userName', this.email);
      }
    })
  }
}
