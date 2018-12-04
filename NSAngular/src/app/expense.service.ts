import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Expense } from './models/expense';
import { throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  private url = 'http://localhost:8080/api';

index() {
  const token = this.authService.getToken();
  const headers = new HttpHeaders()
  .set('Authorization', `Basic ${token}`);
  console.log(token);
  return this.http.get<Expense[]>(this.url + '/expenses', { headers })
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Error in expense index');
    })
  );
}

createExpense(expense: Expense) {
  const token = this.authService.getToken();
  const headers = new HttpHeaders()
  .set('Authorization', `Basic ${token}`);
  console.log(token);
  return this.http.post(this.url + '/expense', expense, { headers })
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Error in create Expense service');
    })
  );
}

updateExpense(expense: Expense, id: number) {
  const token = this.authService.getToken();
  const headers = new HttpHeaders()
  .set('Authorization', `Basic ${token}`);
  console.log(token);
  return this.http.put<Expense>(this.url + '/expense/' + id, expense, { headers })
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Kaboom in update expense service');
    })
  );
}

  constructor(private http: HttpClient, private authService: AuthService) { }
}
