
import { Component,OnInit } from '@angular/core';
import {Router,} from '@angular/router';
import {ActivatedRoute} from '@angular/router'
import {LoginService} from './Login Page/login.service';
import {Http} from '@angular/http';
import {HomeService} from './Home Page/home.service';
@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
})
export class AppComponent implements OnInit{
  constructor(private _loginService :LoginService,private _homeService:HomeService){}
  isloginers=false;
  isloggedin=false;
  errorMsg;
  postError;
  _http:Http;
  ngOnInit(){

    console.log("in Oninit");
    this._loginService.changes.subscribe(status =>this.isloggedin= status);
    this._loginService.checkForSession()
      .subscribe(data => {
          if ( data === true) {
            console.log("data is valid");
            this.isloggedin=data;



          }
          else{

            console.log("no session");
          }
        },
        dataError => {this.postError = dataError;console.log(this.postError)});


  }

logout(){
    this._homeService.categoriesNull();

  this._loginService.logout()
    .subscribe(reslogoutData => this.isloggedin=reslogoutData);


}

}

