import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from "@angular/forms";
import { HistoryComponent} from './history.component'
/*import {LoginService} from './login.service';*/
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
   HistoryComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [/*LoginService*/],
  bootstrap: [HistoryComponent]
})
export class HistoryModule { }
