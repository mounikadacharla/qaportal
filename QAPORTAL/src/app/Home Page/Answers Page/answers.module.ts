import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {AnswersComponent} from './answers.component';
import {AnswersService} from './answers.service';
@NgModule({
  declarations: [
    AnswersComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [AnswersService],
  bootstrap: [AnswersComponent]
})
export class AnswersModule {
}
