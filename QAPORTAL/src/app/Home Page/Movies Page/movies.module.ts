import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from "@angular/forms";
import {MoviesComponent} from './movies.component';
/*import {LoginService} from './login.service';*/
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
   MoviesComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [/*LoginService*/],
  bootstrap: [MoviesComponent]
})
export class MoviesModule { }
