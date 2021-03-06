import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';

@Injectable()
export class HomeService {
  private _urlCategory: string = 'http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/category';
  private _urlAskingQuestion:string='http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/askquestion';
  private categories = null;
  private isLoaded = false;

  constructor(private _http: Http) {
  }

  public getIsLoaded() {
    return this.isLoaded;
  }

  getCategories() {
    if (this.categories) {
      return this.categories;
    } else {
      console.log('Home service failed to return  categories, calling rest');
      return this._http.get(this._urlCategory)
        .map((response: Response) => {
            this.categories = response.json();
            this.isLoaded = true;
            return response.json();
          }
        )
        .catch(this._errorHandler);
    }


  }
 postData(category,question) {
   let postData = {
     'sid_topic': category,
     'sid_person':2,
     'question': question
   }

   var headers = new Headers();
   headers.append('Content-Type',
     'application/json');

   return this._http.post(this._urlAskingQuestion, postData)
     .map((res: Response) => res.json());
 }


  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || 'server error');
  }
}
