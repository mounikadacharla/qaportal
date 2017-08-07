/*import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing-module';


import { AppComponent } from './app.component';
import {LoginComponent} from './login.component';
import {RegistrationComponent} from './registration.component';
import {routingComponents} from './app-routing-module';



@NgModule({
  declarations: [
    AppComponent, routingComponents
  ],
  imports: [
    BrowserModule, ReactiveFormsModule, AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }*/
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';

import {Http, HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import {LoginModule} from './Login Page/login.module';
import {RegistrationModule} from './Registration page/registration.module';
import {FormsModule} from '@angular/forms';
import {RegistrationComponent} from './Registration page/registration.component';
import {LoginComponent} from './Login Page/login.component';

import { HomeComponent} from './Home Page/home.component';
import { HomeModule} from './Home Page/home.module';





@NgModule({
  declarations: [
    AppComponent,HomeComponent/*,RegistrationComponent,LoginComponent*/
  ],
  imports: [HttpModule,
    BrowserModule, ReactiveFormsModule, FormsModule, AppRoutingModule,LoginModule,RegistrationModule,HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
