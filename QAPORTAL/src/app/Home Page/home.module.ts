import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
import {HomeComponent} from './home.component';
import { NgModule} from '@angular/core';
@NgModule({
  declarations: [
  ],
  imports: [

    HttpModule, FormsModule
  ],
  providers: [],
  bootstrap: [HomeComponent]
})
export class HomeModule { }
