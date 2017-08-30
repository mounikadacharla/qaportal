import {Component, OnInit} from '@angular/core';
import {TopicService} from '../Topics/topic.service';
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {AnswersService} from './answers.service';

@Component({
  selector: 'app-topic',
  templateUrl: './answers.component.html',
  styleUrls: ['./answers.component.css']
})
export class AnswersComponent implements OnInit {
  public itemId;
  questionId;
  postedData;
  postError;
  answers = [];
  question;
  postAnswerFlag: boolean = false;
  editAnswerFlag: boolean = false;
  answerId;
  sid;


  editedAnswer: string;

  constructor(private route: ActivatedRoute, private _topicService: TopicService, private router: Router, private _answersService: AnswersService) {
  }

  ngOnInit() {
    console.log('hi');
    this.sid = window.localStorage.getItem('sid');
    this.questionId = this.route.snapshot.params['questionId'];
    this.itemId = this.questionId;
    console.log('Question iD', this.questionId);
    this.getAnswers();
  }

  getAnswers() {
    this._answersService.getQuestion(this.questionId)
      .subscribe(resQuestion => this.question = resQuestion);

    this._answersService.getAnswers(this.questionId)
      .subscribe(resAnswersData => this.answers = resAnswersData);
  }

  onClickBack() {
    this.router.navigate(['./home']);
  }

  onAnswerClick() {
    this.postAnswerFlag = true;
  }

  onCloseClick() {
    this.postAnswerFlag = false;
  }

  onSubmitAnswerClick(value) {
    console.log(value, this.itemId);
    this.sid = window.localStorage.getItem('sid');
    this._topicService.onSubmitClick(this.itemId, this.sid, value)
      .subscribe(resRegistrationData => {
          this.postedData = resRegistrationData;
          console.log(this.postedData);
          this.getAnswers();
        },
        resRegistrationError => {
          this.postError = resRegistrationError;
          console.log('Err', resRegistrationError);
        });
    this.postAnswerFlag = false;
  }

  onClickEdit(id, answer) {
    this.editAnswerFlag = true;
    this.editedAnswer = answer;
    this.answerId = id;
    console.log('Result', id, answer);


  }

  onCloseEditWindow() {
    this.editAnswerFlag = false;
  }

  onSubmitEdittedAnswer() {

    console.log(this.answerId, this.editedAnswer);

    this.sid = window.localStorage.getItem('sid');
    this._answersService.onSubmitEdittedAnswer(this.answerId, this.editedAnswer)
      .subscribe(resRegistrationData => {
          this.postedData = resRegistrationData;
          console.log(this.postedData);
          this.getAnswers();
        },
        resRegistrationError => {
          this.postError = resRegistrationError;
          console.log('Err', resRegistrationError);
        });
    this.editAnswerFlag = false;

    this.router.navigate(['home/topic/answers', this.questionId]);


  }
}
