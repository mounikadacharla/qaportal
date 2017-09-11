
import {Component,OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { RegistrationService} from "./registration.service";
import {Router} from "@angular/router";
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent{
  postedData : string;
  postError : string;
  checkUser=false;
  userForm = new FormGroup({
    firstName: new FormControl(),
    lastName: new FormControl(),
    emailId: new FormControl(),
    userName: new FormControl(),
    password: new FormControl()
  });
  constructor(private _registrationService:RegistrationService,private router:Router
              ){

  }

  ngOnInit(){

  }
    public onsubmit(value){
    console.log(value);

      console.log("working");
      this._registrationService.postData(this.userForm.value.firstName,this.userForm.value.lastName,this.userForm.value.emailId,this.userForm.value.userName,this.userForm.value.password)
        .subscribe(resRegistrationData=>this.postedData=JSON.stringify(resRegistrationData),
          resRegistrationError=>this.postError=resRegistrationError);
      this.router.navigate(['./login']);
  }
  SearchUser(value){
      this.checkUser=false;
      console.log(value);
    this._registrationService.SearchUser(value)
      .subscribe(data=>{
        if(data === true){
          this.checkUser=true;
        }
      },dataError => {this.postError = dataError;console.log(this.postError)});

  }
}
