import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Http,Response} from "@angular/http";
import {map} from "rxjs/operator/map";
import { Headers} from '@angular/http';
@Injectable()
export class AuthGuard implements CanActivate{
  isvalidUser=false;
  result=false;
  constructor(private router :Router,private _http:Http){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    var headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    this._http.get("http://localhost:8080/QAPORTAL-1.0-SNAPSHOT/checkSession",{headers: headers,withCredentials:true})
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
}
