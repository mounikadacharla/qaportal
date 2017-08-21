import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw"
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http'
@Injectable()
export class QuestionsService{
  question;
  private _url: string="http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/home";
  private _urlForAnswers: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/questionid";
  private _urlForAnswering:string= "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/answertoquestion";

  constructor(private _http:Http){}
  getQuestions(){
    return this._http.get(this._url)
      .map((response:Response)=>response.json())
      .catch(this._errorHandler)
  }
  _errorHandler(error:Response){
    console.error(error);
    return Observable.throw(error||"server error");
  }
  onQuestionClick(value){
    let postData=value;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlForAnswers,postData)
      .map((res: Response) => res.json());
  }
  onSubmitAnswer(value,sid,questionId){
    let postData={

      'sid_question':questionId,
      'sid_person':sid,
      'answer':value,
    }

    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlForAnswering,postData,{headers:headers,withCredentials:true})
      .map((res: Response) => res.json());
  }


}
