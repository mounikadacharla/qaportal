import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from "@angular/forms";
import {JavaComponent} from "./java.component";
/*import {LoginService} from './login.service';*/
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
   JavaComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [/*LoginService*/],
  bootstrap: [JavaComponent]
})
export class JavaModule { }
