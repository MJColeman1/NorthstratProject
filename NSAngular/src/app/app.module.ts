import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExpenseComponent } from './expense/expense.component';
import { UserComponent } from './user/user.component';
import { TravelComponent } from './travel/travel.component';
import { UserService } from './user.service';
import { ExpenseService } from './expense.service';
import { TravelService } from './travel.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { AuthService } from './auth.service';
import { RegisterComponent } from './register/register.component';
import { NavigationComponent } from './navigation/navigation.component';

const routes: Routes = [
{ path: '', pathMatch: 'full', redirectTo: 'login'},
{ path: 'user', component: UserComponent },
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RegisterComponent },
{ path: '**', component: NotFoundComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    ExpenseComponent,
    UserComponent,
    TravelComponent,
    LoginComponent,
    NotFoundComponent,
    RegisterComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    [RouterModule.forRoot(routes)]
  ],
  exports: [RouterModule],
  providers: [UserService, ExpenseService, TravelService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
