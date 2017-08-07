/*import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {RegistrationComponent} from './registration.component';



@NgModule({
  declarations: [RegistrationComponent],
  imports: [
    BrowserModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: []
})
export class RegistrationModule { }*/
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegistrationComponent} from './registration.component';
import {RegistrationService} from "./registration.service";
import {HttpModule} from '@angular/http';
import {CommonModule} from '@angular/common'
@NgModule({
  declarations: [RegistrationComponent],
  imports: [
    BrowserModule, ReactiveFormsModule,HttpModule, FormsModule
  ],
  providers: [RegistrationService],
  bootstrap: [RegistrationComponent]
})
export class RegistrationModule { }
