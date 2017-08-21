import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Http, Response} from '@angular/http';
import {Headers} from '@angular/http';

@Injectable()
export class AuthGuard implements CanActivate {
  validUser = false;
  result = false;
  private errorMsg;
  private flag;

  constructor(private router: Router, private _http: Http) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return new Promise<boolean>((resolve, reject) => this._http.get('http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession', {
        headers: headers, withCredentials: true
      })
        .map((response: Response) => response.json())
        .subscribe(data => {
            this.flag = data;
            if (this.flag === true) {

            } else if (this.flag === false) {
              this.router.navigate(['/login']);
            }
            resolve(true);
          }
          ,
          dataError => {
            this.errorMsg = dataError;
            resolve(false);
          }
        )
    );
  }
}

/*import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Http,Response} from "@angular/http";
import {map} from "rxjs/operator/map";
import { Headers} from '@angular/http';
@Injectable()
export class AuthGuard implements CanActivate {
  isvalidUser = false;
  result = false;
  flag;
  errorMsg;

  constructor(private router: Router, private _http: Http) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return new Promise<boolean>((resolve, reject) => this._http.get("http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession", {
        withCredentials: true
      })
        .map((response: Response) => response.json())
        .subscribe(data => {
            this.flag = data;
            if (this.flag === true) {

            }
            else if (this.flag === false) {
              this.router.navigate(['/login']);
            }
            resolve(true)
          }
          ,
          dataError => {
            this.errorMsg = dataError;
            resolve(false)
          }
        )
    )
  }
}*/
   /* this._http.get("http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession",{headers: headers,withCredentials:true})
      .map((response:Response)=>response.json())
      .subscribe(
        data=>this.isvalidUser= data,
        error=>{},
        ()=>{
          if(this.isvalidUser==true){
            this.result=true;
          }
          else{
            this.router.navigate(['/login']);
            this.result= false;
          }
        }
      );
    return this.result;
  }
}*/

/*


import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import { LoginService} from './Login Page/login.service';


@Injectable()
export class AuthGuard implements CanActivate
{

  private errorMsg;
  private isUserLogged;

  constructor(private loginService: LoginService, private route: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {

    return new Promise<boolean>((resolve, reject) =>this.loginService.checkForSession()
      .subscribe(data => {
          this.isUserLogged = data;
          if (this.isUserLogged === true)
          {
          }
          else if (this.isUserLogged === false) {
            this.route.navigate(['/login']);
          }
          resolve(true)
        }
        ,
        dataError => {
          this.errorMsg = dataError;
          resolve(false)
        }
      )
    )
  }
}
*/



/*
import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Http,Response} from "@angular/http";
import {map} from "rxjs/operator/map";
import { Headers} from '@angular/http';
import {LoginService} from './Login Page/login.service';
@Injectable()
export class AuthGuard implements CanActivate {
  isvalidUser = false;
  result = false;
  private errorMsg;
  postError;
  private flag;

  constructor(private router: Router, private _http: Http, private _loginService: LoginService) {
  }
*/

 /* canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
*/
    /* return new Promise<boolean>((resolve, reject) =>this._loginService.checkForSession()
       .subscribe(data => {
           this.flag = data;
           if (this.flag === true)
           {

           }
           else if (this.flag === false)
           {
             this.router.navigate(['/login']);
           }
           resolve(true)
         }
         ,
         dataError => {
           this.errorMsg = dataError;
           resolve(false)
         }
       )
     )
   }
 }
 */
    /* canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
       var headers = new Headers();
       headers.append('Content-Type',
         'application/json');
       this._loginService.checkForSession()
         .subscribe(data => {
             if ( data === true) {
               console.log("data is valid");
               this.flag=data;



             }
             else{

               this.router.navigate(['/login']);
             }
           },
           dataError => {this.postError = dataError;console.log(this.postError)});


     }*/
   /* return new Promise<boolean>((resolve, reject) => this._http.get("http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession", {
        withCredentials: true
      })
        .map((response: Response) => response.json())
        .subscribe(data => {
            this.flag = data;
            if (this.flag === true) {

            }
            else if (this.flag === false) {
              this.router.navigate(['/login']);
            }
            resolve(true)
          }
          ,
          dataError => {
            this.errorMsg = dataError;
            resolve(false)
          }
        )
    )
  }
}*/


  /*canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    this._http.get("http://192.168.35.54:8080/QAPORTAL-1.0-SNAPSHOT/checkSession",{headers: headers,withCredentials:true})
      .map((response:Response)=>response.json())
      .subscribe(
        data=>this.isvalidUser= data,
        error=>{},
        ()=>{
          if(this.isvalidUser==true){
            this.result=true;
          }
          else{
            this.router.navigate(['/login']);
            this.result= false;
          }
        }
      );
    return this.result;
  }
}*/

