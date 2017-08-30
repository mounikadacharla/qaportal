
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './Login Page/login.component';
import {RegistrationComponent} from './Registration page/registration.component';
import {HomeComponent} from './Home Page/home.component';
import {TopicComponent} from './Home Page/Topics/topic.component';
import {QuestionsComponent} from './Home Page/TotalQuestionsPage/questions.component';
import { AnswersComponent} from './Home Page/Answers Page/answers.component';
import {AuthGuard} from './auth-guard';
const routes: Routes =
  [ {path:'', redirectTo : '/home', pathMatch : 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'home', component:HomeComponent,canActivate:[AuthGuard],
      children: [
        {path: '', component : QuestionsComponent,canActivate:[AuthGuard] },
        {path:'topic/:name', component: TopicComponent,canActivate:[AuthGuard]},
        {path:'topic/answers/:questionId', component:AnswersComponent,canActivate:[AuthGuard]},
      ]},
  ];


@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]

})

export class AppRoutingModule {}
export const RoutingComponents = [LoginComponent, RegistrationComponent]
