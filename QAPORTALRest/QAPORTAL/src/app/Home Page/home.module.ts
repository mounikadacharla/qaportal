
import {HttpModule} from '@angular/http';
import { FormsModule} from '@angular/forms';
import {HomeComponent} from './home.component';
import { NgModule} from '@angular/core';
import {CommonModule} from '@angular/common'
import { BrowserModule } from '@angular/platform-browser';
import { QuestionsModule} from './TotalQuestionsPage/questions.module'
import {HomeService} from './home.service';
import {TopicModule} from './Topics/topic.module';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [HomeComponent],
  imports: [
    HttpModule, FormsModule,TopicModule,CommonModule, RouterModule,BrowserModule,QuestionsModule
  ],
  providers: [HomeService],
  bootstrap: [HomeComponent]
})
export class HomeModule { }

