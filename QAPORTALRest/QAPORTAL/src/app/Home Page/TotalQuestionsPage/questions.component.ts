import {Component} from '@angular/core';
import {QuestionsService} from './questions.service';
import {SearchService} from '../Topics/Search.service';

@Component({
  selector : "my-home",
  templateUrl : './questions.component.html',
  styleUrls:['./question.component.css']
})
export class QuestionsComponent{

  questions=[];
  answers=[];
  questionsFlag=true;
  answersFlag=false;
  question;
  questionId;
  postData:string;
  postError:string;
  postAnswerFlag:boolean=false;
  errorMsg:string;
  constructor(private _questionsService:QuestionsService,private _searchService:SearchService){}
  ngOnInit(){
    this._questionsService.getQuestions()
      .subscribe(resQuestionData=>this.questions=resQuestionData);
  }
  onQuestionClick(value){
    this.question=value;
    this.questionsFlag=false;
    this.answersFlag=true;
    this.question=value.question;
    this.questionId=value.questionId;
    this._questionsService.onQuestionClick(value.questionId)
      .subscribe(resAnswersData=>this.answers=resAnswersData);

  }
  onClick(){
    this.questionsFlag=true;
    this.answersFlag=false;
  }
  SearchText(value){
    console.log(value);
    this._searchService.searchText(value)
      .subscribe(resAnswersData=>this.questions=resAnswersData);
  }

  onAnswerClick()
  {
    this.postAnswerFlag=true;
  }
  onCloseClick()
  {
    this.postAnswerFlag=false;
  }
  onSubmitClick(value){

    console.log(value,this.questionId);
    this._questionsService.onSubmitAnswer(value,this.questionId)
      .subscribe(resRegistrationData=>this.postData=resRegistrationData,
        resRegistrationError=>this.postError=resRegistrationError);
  }



}
