
import {Component} from '@angular/core';
import {Router} from '@angular/router';
import { CategoryService} from './category.service';
import {LoginService} from '../Login Page/login.service';

@Component({
  selector: 'my-home',
  templateUrl: './home.component.html',
})
export class HomeComponent {
  categories = [];
  postedData :string;
  postError :string;
  isloggedin=false;

  constructor(private _categoryService: CategoryService,
              private router: Router,
              private _loginService:LoginService) {
  }

  ngOnInit() {
    this._categoryService.getCategories()
      .subscribe(resCategoryData => {
        this.categories = resCategoryData;
      });
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


  onSubmitQuestion(category,question){
    var sid=localStorage.getItem("sid");
    this._categoryService.onSubmitQuestion(category,sid,question)
      .subscribe(resRegistrationData=>this.postedData=JSON.stringify(resRegistrationData),
        resRegistrationError=>this.postError=resRegistrationError);
    window.location.reload();

  }
}

