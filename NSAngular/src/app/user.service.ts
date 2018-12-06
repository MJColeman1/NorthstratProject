import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user';
import { throwError, Observable } from 'rxjs';
import { HttpHeaders} from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class UserService {
  private url = 'http://localhost:8080/api';

  index() {
    return this.http.get<User[]>(this.url + '/users')
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in user index');
      })
    );
  }

  getUser() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.get<User>(this.url + '/user', { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error in find User Service');
      })
    );
  }

  createUser (user: User) {
    return this.http.post<User>(this.url + '/user', user)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in create user');
      })
    );
  }

  updateUser(user: User) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.put<User>(this.url + '/updateuser', user, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Kaboom in update user service');
      })
    );
  }

  updateUsernameAndPassword(user: User) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.put<User>(this.url + '/updatepassword', user, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('kaboom in update password user service');
      })
    );
  }

  constructor(private http: HttpClient, private authService: AuthService) { }
}
