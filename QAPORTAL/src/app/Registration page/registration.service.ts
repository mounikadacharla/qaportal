import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
/*import {Observable} from "rxjs/Observable";*/
import {Headers} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class RegistrationService{
  private _urlPost:string= "http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/adduser";
  constructor(private _http:Http){}
  postData(firstName,lastName,emailId,userName,password)
  {
    let postData={
      'firstName':firstName,
      'lastName':lastName,
      'emailId':emailId,
      'userName':userName,
      'password':password,
    };
    var headers=new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlPost,postData)
      .map((res:Response)=>res.json());

  }
}
