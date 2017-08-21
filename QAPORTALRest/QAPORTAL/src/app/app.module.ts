import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {Http, HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router'
import {AppComponent} from './app.component';
import {LoginModule} from './Login Page/login.module';
import {RegistrationModule} from './Registration page/registration.module';
import {FormsModule} from '@angular/forms';
import {HomeModule} from './Home Page/home.module';
import {AuthGuard} from './auth-guard';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [HttpModule,
    BrowserModule, ReactiveFormsModule, FormsModule, AppRoutingModule, LoginModule, RegistrationModule, HomeModule, RouterModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
