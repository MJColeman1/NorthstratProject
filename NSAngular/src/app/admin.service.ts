import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Expense } from './models/expense';
import { Travel } from './models/travel';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private url = 'http://localhost:8080/api';

  getAllExpenses() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.get<Expense[]>(this.url + '/allexpenses', { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Kaboom in get all expense reports admin service');
      })
    );
  }

  getAllTravel() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    console.log(token);
    return this.http.get<Travel[]>(this.url + '/alltravel', { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('kaboom in get all travel admin service');
      })
    );
  }

  updateExpenseByAdmin(expense: Expense, id: number) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    return this.http.put<Expense>(this.url + '/adminexpenseupdate/' + id, expense, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('kaboom in update expense admin service');
      })
    );
  }
  updateTravelByAdmin(travel: Travel, id: number) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    return this.http.put<Travel>(this.url + '/admintravelupdate/' + id, travel, { headers })
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('kaboom in update expense admin service');
      })
    );
  }

  constructor(private http: HttpClient, private authService: AuthService) { }
}
