import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';
import { Constants} from '../constants/constants';

@Injectable()
export class TopicService {
  constructor(private _http: Http) {
  }
  getTotalQuestions(){
    return this._http.get(Constants.url+'/home')
      .map((response:Response)=>response.json())
      .catch(this._errorHandler)
  }
  _errorHandler(error:Response){
    console.error(error);
    return Observable.throw(error||"server error");
  }

  getQuestions(id) {
    let postData = id;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    console.log('####sending post data : ', postData);
    return this._http.post(Constants.url+'/id', postData)
      .map((res: Response) => res.json());

  }
  onQuestionClick(value){
    let postData=value;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(Constants.url+'/questionid',postData)
      .map((res: Response) => res.json());
  }
  onSubmitClick(questionId,sid_person,value){
    let postData={
      'sid_question':questionId,
      'sid_person':sid_person,
      'answer':value,
    }
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(Constants.url+'/answertoquestion',postData,)
      .map((res: Response) => res.json());
  }

}

