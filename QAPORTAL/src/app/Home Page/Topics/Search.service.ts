import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw'
import {Headers} from '@angular/http';
@Injectable()
export class SearchService{
  private _urlSearch:string="http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/search";
  constructor(private _http: Http) {
  }
  searchText(value){
    let postData=value;
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlSearch, postData)
      .map((res: Response) => res.json());
  }
}
