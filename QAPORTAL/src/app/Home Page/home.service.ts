import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';

@Injectable()
export class HomeService {
  private _urlCategory: string = 'http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/category';
  private _urlAskingQuestion:string='http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/askquestion';
  private categories = null;
  private isLoaded = true;

  constructor(private _http: Http) {
  }

  public getIsLoaded() {
    console.log(this.isLoaded);
    return this.isLoaded;
  }

  getCategories() {
    /*this.categories=null;*/
  if (this.categories) {
    console.log("home service");
 /*   return this._http.get(this._urlCategory)
      .map((response: Response) => {
          this.categories = response.json();
          this.isLoaded = true;
          return response.json();
        }
      )
      .catch(this._errorHandler);*/

    return this.categories;
    } else {
    console.log(this.categories);
    console.log(this.isLoaded);
    console.log('Home service failed to return  categories, calling rest');
    return this._http.get(this._urlCategory)
      .map((response: Response) => {
          this.categories = response.json();
          this.isLoaded = true;
        /*  this.categories=null;*/
          return response.json();
        }
      )
      .catch(this._errorHandler);
  }




  }
  categoriesNull(){
    this.categories=null;
  }
  postData(category,sid,question) {
    let postData = {
      'sid_topic': category,
      'sid_person':sid,
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
