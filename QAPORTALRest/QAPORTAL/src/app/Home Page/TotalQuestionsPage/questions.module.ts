import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
import { NgModule} from '@angular/core';
import {QuestionsService} from './questions.service'
import { BrowserModule} from '@angular/platform-browser';
import {QuestionsComponent} from './questions.component';
import {CommonModule} from '@angular/common';
import {SearchService} from '../Topics/Search.service';

@NgModule({
  declarations: [QuestionsComponent],
  imports: [

    HttpModule, FormsModule,BrowserModule,CommonModule
  ],
  providers: [QuestionsService,SearchService],
  bootstrap: [QuestionsComponent]
})
export class QuestionsModule { }
