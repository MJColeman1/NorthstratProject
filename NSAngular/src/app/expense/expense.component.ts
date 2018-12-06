import { Component, OnInit, Input } from '@angular/core';
import { Expense } from '../models/expense';
import { ExpenseService } from '../expense.service';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  expense: Expense = new Expense();

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  createExpense(expense: Expense) {
    return this.expenseService.createExpense(expense).subscribe(
      data => {
        this.expense = data;
        this.router.navigateByUrl('user');
      },
      error => console.log(error + ' kaboom in create expense component'));
  }

  constructor(private expenseService: ExpenseService, private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

}
