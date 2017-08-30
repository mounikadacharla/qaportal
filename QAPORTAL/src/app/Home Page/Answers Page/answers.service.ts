import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Headers} from '@angular/http';
@Injectable()
export class AnswersService{
  private _urlForAnswers: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/answers";
  private _urlForQuestion: string =  "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/questionId";
  private _urlForEdittingAnswer: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/edit";

  constructor(private _http: Http) {
  }
  getQuestion(questionId){
    let postData=questionId;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlForQuestion,postData)
      .map((res: Response) => res.text());
  }
  getAnswers(questionId){
    let postData=questionId;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlForAnswers,postData)
      .map((res: Response) => res.json());
  }
  onSubmitEdittedAnswer(answerId,edittedAnswer){
    let postData={
      'sid_answer':answerId,
      'answer':edittedAnswer,
    }
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlForEdittingAnswer,postData)
      .map((res: Response) => res.json());
  }
}
