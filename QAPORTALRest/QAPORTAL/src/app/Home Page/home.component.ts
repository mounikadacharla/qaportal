import {CommonModule} from '@angular/common';
import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {RouterLink} from '@angular/router';
import {HomeService} from './home.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'my-home',
  templateUrl: './home.component.html',
})
export class HomeComponent {
  categories = [];
  postedData :string;
  postError :string;

  constructor(private _categoryService: HomeService,
              private router: Router) {
  }

  ngOnInit() {
    this._categoryService.getCategories()
      .subscribe(resCategoryData => {
        this.categories = resCategoryData;
        console.log('######## categories : ', this.categories)
      });
  }

onSubmit(category,question){
    this._categoryService.postData(category,question)
      .subscribe(resRegistrationData=>this.postedData=JSON.stringify(resRegistrationData),
        resRegistrationError=>this.postError=resRegistrationError);
}
  /*onSubmitingQuestion()*/

  /*categories=[];
  questions=[];
  errorMsg:string;
  constructor(private _homeService:HomeService){}
  ngOnInit(){
    this._homeService.getHome()
      .subscribe(resHomeData=>this.questions=resHomeData);
  }*/
}

