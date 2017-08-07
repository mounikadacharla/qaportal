import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from "@angular/forms";
import {SqlComponent} from './sql.component';
/*import {LoginService} from './login.service';*/
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
    SqlComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [/*LoginService*/],
  bootstrap: [SqlComponent]
})
export class SqlModule{ }
