import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {SearchComponent} from './search.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {SearchService} from './search.service';
import {LoginService} from '../../Login Page/login.service';
@NgModule({
  declarations: [
    SearchComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule, FormsModule,NgxPaginationModule
  ],
  providers: [SearchService,LoginService],
  bootstrap: [SearchComponent]
})
export class SearchModule{

}
