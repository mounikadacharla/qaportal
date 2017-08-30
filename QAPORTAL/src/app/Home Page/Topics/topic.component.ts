import {Component, OnInit} from '@angular/core';
import {TopicService} from './topic.service';
import {ActivatedRoute} from '@angular/router';
import { CategoryService} from '../category.service'
import {SearchService} from './Search.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls:['./topic.component.css']
})
export class TopicComponent implements OnInit {
  questions = [];
  answers = []
  questionsFlag = true;
  question;
  questionId;
  p = 1;

  postAnswerFlag: boolean = false;

  constructor(private route: ActivatedRoute, private _topicService: TopicService, private _categoryService: CategoryService, private _searchService: SearchService,private router:Router) {
  }

  categories = null;

  ngOnInit() {
    this.route.params.subscribe(params => {
        var name = params['name'];
        if (this.categories == null) {
          if (this._categoryService.getIsLoaded()) {
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
      }
    }
    this._topicService.getQuestions(this.id)
      .subscribe(resQuestionsData => this.questions = resQuestionsData);
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
