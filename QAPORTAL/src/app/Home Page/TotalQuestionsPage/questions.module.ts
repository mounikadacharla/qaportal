import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
import { NgModule} from '@angular/core';
import {QuestionsService} from './questions.service'
import { BrowserModule} from '@angular/platform-browser';
import {QuestionsComponent} from './questions.component';
import {CommonModule} from '@angular/common';
import {SearchService} from '../Topics/Search.service';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [QuestionsComponent],
  imports: [

    HttpModule, FormsModule,BrowserModule,CommonModule,NgxPaginationModule
  ],
  providers: [QuestionsService,SearchService],
  bootstrap: [QuestionsComponent]
})
export class QuestionsModule { }
