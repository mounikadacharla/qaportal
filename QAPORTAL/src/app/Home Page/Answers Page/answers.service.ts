import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Headers} from '@angular/http';
import { Constants} from '../constants/constants';
@Injectable()
export class AnswersService{
  private _urlForQuestion: string =  "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/questionId";
  private _urlForEdittingAnswer: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/edit";
  private _urlForDeletingAnswer: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/delete";

  constructor(private _http: Http) {
  }
  getQuestion(questionId){
    let postData=questionId;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(Constants.url+'/questionId',postData)
      .map((res: Response) => res.text());
  }
  getAnswers(questionId){
    let postData=questionId;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(Constants.url+'/answers',postData)
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

    return this._http.post(Constants.url+'/edit',postData)
      .map((res: Response) => res.json());
  }
  onClickDelete(value){
    let postData=value;
    var headers = new Headers();
    headers.append('Content-Type',
      'text/plain');
    return this._http.post(Constants.url+'/delete',postData)
      .map((res: Response) => res.text());
  }
}
