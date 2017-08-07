import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MoviesComponent} from './Movies Page/movies.component';
import {SqlComponent} from './SQL/sql.component';
import {JavaComponent} from './Java/java.component';
import {Java_scriptComponent} from './JAVA SCRIPT/java_script.component';
import {HistoryComponent} from './History Page/history.component';
import {GamesComponent} from './Games Page/games.component';
const routes: Routes =
  [ {path:'', redirectTo : 'home', pathMatch : 'full'},
    {path: 'java', component: JavaComponent},
    {path: 'javascript', component: Java_scriptComponent},
    {path: 'sql', component:SqlComponent},
    {path: 'movies', component: MoviesComponent},
    {path: 'history', component: HistoryComponent},
    {path: 'games', component: GamesComponent}
  ];


@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]

})

export class HomeRoutingModule {}
export const RoutingComponents = [JavaComponent,Java_scriptComponent,SqlComponent,MoviesComponent,HistoryComponent,GamesComponent]
