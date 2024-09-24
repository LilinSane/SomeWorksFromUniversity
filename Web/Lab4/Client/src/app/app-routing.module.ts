import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {MainComponent} from "./main/main.component";
import {AuthGuard} from "./guard/auth.guard";

//mapping
const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'reg', component: RegisterComponent},
  { path: 'main', component: MainComponent, canActivate: [AuthGuard]},
  { path: '', redirectTo: 'main', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
