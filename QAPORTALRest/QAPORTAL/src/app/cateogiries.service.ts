import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw"
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';
@Injectable()
export class CateogiriesService {
  private _urlCategory: string = "http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/category";
  private _urlDifferentCategories: string = "http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/id";

  constructor(private _http: Http) {
  }

  getCategory() {
    return this._http.get(this._urlCategory)
      .map((response: Response) => response.json())
      .catch(this._errorHandler)
  }

  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "server error");
  }
 getQuestions(id) {
    let postData =id;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlDifferentCategories, postData)
      .map((res: Response) => res.json());

  }




}
