
import { Component,OnInit } from '@angular/core';
import {LoginService} from './Login Page/login.service';
import {Http} from '@angular/http';
import { CategoryService} from './Home Page/category.service';
@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
})
export class AppComponent implements OnInit{
  constructor(private _loginService :LoginService,private _categoryService:CategoryService){}
  isloginers=false;
  isloggedin=false;
  errorMsg;
  postError;
  username;
  _http:Http;
  ngOnInit(){

    console.log("in Oninit");
    this._loginService.changes.subscribe(status =>this.isloggedin= status);
    this._loginService.checkForSession()
      .subscribe(data => {
          if ( data === true) {
            console.log("data is valid");
            this.isloggedin=data;
            this.username=localStorage.getItem("username");



          }
          else{

            console.log("no session");
          }
        },
        dataError => {this.postError = dataError;console.log(this.postError)});


  }

logout(){
    this._categoryService.categoriesNull();

  this._loginService.logout()
    .subscribe(reslogoutData => this.isloggedin=reslogoutData);


}

}

