import {Component} from '@angular/core';
import {QuestionsService} from './questions.service';
import {SearchService} from '../Topics/Search.service';
import {Router} from '@angular/router';

@Component({
  selector : "my-home",
  templateUrl : './questions.component.html',
  styleUrls:['./question.component.css']
})
export class QuestionsComponent{
  p=1;
  questions=[];
  answers=[];
  question;
  questionId;
  constructor(private _questionsService:QuestionsService,private _searchService:SearchService,private router:Router){}
  ngOnInit() {
    this._questionsService.getQuestions()
      .subscribe(resQuestionData => this.questions = resQuestionData);
  }
  onQuestionClick(value){
    this.router.navigate(['home/topic/answers',value.questionId]);
  }
  SearchText(value){
    console.log(value);
    this._searchService.searchText(value)
      .subscribe(resAnswersData=>this.questions=resAnswersData);
  }
}
