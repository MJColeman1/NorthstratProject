import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Travel } from './models/travel';
import { throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class TravelService {

  private url = 'http://localhost:8080/api';

  getToken() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    return headers;
  }

  index() {
    const headers = this.getToken();
    return this.http.get<Travel[]>(this.url + '/travel', { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in travel index');
      })
    );
  }

  createTravel(travel: Travel) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.post(this.url + '/travel', travel, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in create Travel service');
      })
    );
  }

  updateTravel(travel: Travel, id: number) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.put<Travel>(this.url + '/travel/' + id, travel, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in update travel service');
      })
    );
  }

  constructor(private http: HttpClient, private authService: AuthService) { }
}
