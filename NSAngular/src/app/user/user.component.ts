import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user';
import { AuthService } from '../auth.service';
import { ExpenseService } from '../expense.service';
import { Expense } from '../models/expense';
import { Travel } from '../models/travel';
import { Router } from '@angular/router';
import { TravelService } from '../travel.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  greeting = 'Hello World';

  users = [];

  selected = null;

  clicked = null;

  updateExpense = null;

  updateTravel = null;

  expenses = [];

  travelReports = [];

  user: User = new User();

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  expense: Expense = new Expense();

  reload() {
    return this.getAllExpenses(), this.getAllTravelReports();
  }

  getAllExpenses() {
    return this.expenseService.index().subscribe(
      data => {
        this.expenses = data;
      },
      error => console.log(error + ' Kaboom in get all expenses user component'));
  }

  displayExpense(expense) {
    this.selected = expense;
  }

  displayExpenseTable() {
    return this.selected = null;
  }

  setEditExpense() {
    this.updateExpense = Object.assign({}, this.selected);
  }

  getAllTravelReports() {
    return this.travelService.index().subscribe(
      data => {
        this.travelReports = data;
      },
      error => console.log(error + ' kaboom in get all travel component'));
  }

  displayTravelReport(travel) {
    this.clicked = travel;
  }

  displayTravelTable() {
    return this.clicked = null;
  }

  setEditTravel() {
    this.updateTravel = Object.assign({}, this.clicked);
  }

  updateExpenseReport(expense: Expense, id: number) {
    this.expenseService.updateExpense(expense, id).subscribe(
    data => {
      this.reload();
    },
    error => console.log(error));
    this.selected = null;
    this.updateExpense = null;
  }

  updateTravelReport(travel: Travel, id: number) {
    this.travelService.updateTravel(travel, id).subscribe(
      data => {
        this.reload();
      },
      error => console.log(error));
      this.clicked = null;
      this.updateTravel = null;
  }

  constructor(private userService: UserService, public authService: AuthService,
  private expenseService: ExpenseService, private router: Router, private travelService: TravelService) { }

  ngOnInit() {
    return this.loggedInUser + this.getAllExpenses() + this.getAllTravelReports();
  }

}
