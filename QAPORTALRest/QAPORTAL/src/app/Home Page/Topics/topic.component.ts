import {Component, OnInit} from '@angular/core';
import {TopicService} from './topic.service';
import {ActivatedRoute} from '@angular/router';
import {HomeComponent} from '../home.component';
import {CateogiriesService} from '../../cateogiries.service';
import {HomeService} from '../home.service';
import {SearchService} from './Search.service';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls:['./topic.component.css']
})
export class TopicComponent implements OnInit {
  questions = [];
  answers=[]
  public value;
  questionsFlag=true;
  answersFlag=false;
  postedData:string;
  postError:string;

  question;
  questionId;

  postAnswerFlag:boolean=false;


  private id;

  constructor(private route: ActivatedRoute, private _topicService: TopicService, private _categoryService: HomeService,private _searchService:SearchService) {
  }

  categories = null;

  ngOnInit() {
    this.route.params.subscribe(params => {
        var name = params['name'];
        if (this.categories == null) {
          if (this._categoryService.getIsLoaded()) {
            alert('getting loaded value')
            this.categories = this._categoryService.getCategories();
            this.getQuestions(name);
          } else {
            this._categoryService.getCategories()
              .subscribe(resCategoryData => {
                this.categories = resCategoryData;
                this.getQuestions(name);
              });
          }

        } else {
          this.getQuestions(name);
        }
      }
    );
  }

  getQuestions = function (name) {
    console.log('######## categories : ', this.categories)
    for (let category of this.categories) {
      if (category.categoryName == name) {
        this.id = category.categoryId;
        alert('got id as ' + this.id)
      }
    }
    this._topicService.getQuestions(this.id)
      .subscribe(resQuestionsData => this.questions = resQuestionsData);
  }
  onQuestionClick(value){
    this.questionsFlag=false;
    this.answersFlag=true;
    this.question=value.question;
    this.questionId=value.questionId;
    this._topicService.onQuestionClick(value.questionId)
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
    this._topicService.onSubmitClick(this.questionId,value)
      .subscribe(resRegistrationData=>this.postedData=JSON.stringify(resRegistrationData),
        resRegistrationError=>this.postError=resRegistrationError);
  }

}

