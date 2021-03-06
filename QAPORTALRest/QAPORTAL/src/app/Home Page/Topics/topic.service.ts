import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';

@Injectable()
export class TopicService {
  private _urlDifferentCategories: string = 'http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/id';
  private _urlForAnswers: string = "http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/questionid";
  private _urlForAnsweringQuestion:string="http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/answertoquesiton";

  constructor(private _http: Http) {
  }

  getQuestions(id) {
    let postData = id;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    console.log('####sending post data : ', postData);
    return this._http.post(this._urlDifferentCategories, postData)
      .map((res: Response) => res.json());

  }
  onQuestionClick(value){
    let postData=value;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlForAnswers,postData)
      .map((res: Response) => res.json());
  }
  onSubmitClick(questionId,value){
    let postData={
      'sid_question':questionId,
      'sid_person':12,
      'answer':value,
    }
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlForAnsweringQuestion,postData)
      .map((res: Response) => res.json());
  }

}
