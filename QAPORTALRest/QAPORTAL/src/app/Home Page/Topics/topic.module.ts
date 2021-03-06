import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {TopicComponent} from './topic.component';
import {TopicService} from './topic.service';
import {SearchService} from './Search.service';

@NgModule({
  declarations: [
    TopicComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule
  ],
  providers: [TopicService,SearchService],
  bootstrap: [TopicComponent]
})
export class TopicModule {
}
