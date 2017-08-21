export class RegistrationModel{
  public firstName:string;
  public lastName:string;
  public emailId:string;
  public userName:string;
  public password:string;
  constructor(firstName,lastName,emailId,userName,password){

    this.firstName=firstName;
    this.lastName=lastName;
    this.emailId=emailId;
    this.userName=userName;
    this.password=password;
  }
}
