import {Component} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from "@angular/router"
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  postedData : string;
  postError : string;
  error: string;
  sid:any;
  UserForm = new FormGroup({
    userName: new FormControl(),
    password: new FormControl()
  });
  constructor(private _loginService:LoginService,private router:Router
  ){

  }

  public onSubmit() {
    console.log("working");
    // value=userForm.value;
    this._loginService.postData(this.UserForm.value.userName,this.UserForm.value.password)
      .subscribe(data => {
          if ( data.isValid === true) {
            this.sid=data.sid;
            window.localStorage.setItem("sid",this.sid)
            console.log("hello");
            console.log(localStorage.getItem("sid"));

            this._loginService.changes.next(true);
            this.router.navigate(['./home']);
          }
          else{
            this.error='invalid details';
            console.log(this.error);
          }
        },
        dataError => {this.postError = dataError;console.log(this.postError)});



  }

}


