import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class LoginService {
  private _urlLogIn: string = "http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/login";

  constructor(private _http: Http) {
  }

  postData(userName, password) {
    let postData = {
      'userName': userName,
      'password': password,
    };
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlLogIn, postData)
      .map((res: Response) => res.json());

  }

  validateData() {
    return this._http.get(this._urlLogIn)
      .map(res => res.json());

  }
}
