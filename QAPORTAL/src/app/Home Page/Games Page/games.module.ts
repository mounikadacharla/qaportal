import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from "@angular/forms";
import {GamesComponent } from "./games.component";
/*import {LoginService} from './login.service';*/
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
   GamesComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [/*LoginService*/],
  bootstrap: [GamesComponent]
})
export class GamesModule { }
