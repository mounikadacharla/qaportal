
import {Component,OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { RegistrationService} from "./registration.service"
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent{
  postedData : string;
  postError : string;
  userForm = new FormGroup({
    firstName: new FormControl(),
    lastName: new FormControl(),
    emailId: new FormControl(),
    userName: new FormControl(),
    password: new FormControl()
  });
  constructor(private _registrationService:RegistrationService,
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
  }
}
