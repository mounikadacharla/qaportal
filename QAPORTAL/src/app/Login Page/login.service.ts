
import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
@Injectable()
export class LoginService {
  loginData:{
    userName:string;
    sid:any;
    isValid:boolean;

  }
  private _urlLogIn: string = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/login";
  private _urllogout="http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/sessionDestroy";

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

    return this._http.post(this._urlLogIn, postData,{headers: headers,withCredentials:true})
      .map((res: Response) =>this.loginData= res.json());

  }
  getLoginData(){
    return this.loginData.sid;
  }
  checkForSession() {
    const _urlCheckSession = "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession";

    return this._http.get(_urlCheckSession, {withCredentials: true })
      .map((response: Response) => response.json())

  }
  logout(){
    return this._http.get(this._urllogout,{  withCredentials: true })
      .map((response:Response)=>response.json());
  }


  validateData() {
    return this._http.get(this._urlLogIn)
      .map(res => res.json());

  }
  changes:BehaviorSubject<any> = new BehaviorSubject(false);
}
