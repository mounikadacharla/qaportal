
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './Login Page/login.component';
import {RegistrationComponent} from './Registration page/registration.component';
import {HomeComponent} from './Home Page/home.component';
const routes: Routes =
  [ {path:'', redirectTo : 'login', pathMatch : 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'home', component: HomeComponent}
  ];


@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]

})

export class AppRoutingModule {}
export const RoutingComponents = [LoginComponent, RegistrationComponent,HomeComponent]
