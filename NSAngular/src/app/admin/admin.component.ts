import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';
import { Expense } from '../models/expense';
import { Travel } from '../models/travel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  expenses = [];

  travelReports = [];

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  selected = null;

  clicked = null;

  updateExpense = null;

  updateTravel = null;

  reload() {
    return this.getAllExpenseReports(), this.getAllTravelReports();
  }

  getAllExpenseReports() {
    return this.adminService.getAllExpenses().subscribe(
      data => {
        this.expenses = data;
      },
      error => console.log(error + ' kaboom in get all expenses admin component'));
  }

  displayExpense(expense) {
    this.selected = expense;
  }

  displayExpenseTable() {
    return this.selected = null;
  }

  updateExpenseReport(expense: Expense, id: number) {
    return this.adminService.updateExpenseByAdmin(expense, id).subscribe(
      data => {
        this.reload();
        this.selected = null;
      },
      error => console.log(error + ' Kaboom in admin update expense report'));
  }

  updateTravelReport(travel: Travel, id: number) {
    return this.adminService.updateTravelByAdmin(travel, id).subscribe(
      data => {
      this.reload();
      this.clicked = null;
      },
      error => console.log(error + ' kaboom in admin update travel report'));
  }


  getAllTravelReports() {
    return this.adminService.getAllTravel().subscribe(
      data => {
        this.travelReports = data;
      },
      error => console.log(error + ' kaboom in get all travel admin component'));
  }

  displayTravelReport(travel) {
    this.clicked = travel;
  }

  displayTravelTable() {
    return this.clicked = null;
  }


  constructor(private adminService: AdminService, public authService: AuthService,
  private router: Router, private userService: UserService) { }

  ngOnInit() {
    return this.loggedInUser + this.getAllExpenseReports() + this.getAllTravelReports();
  }

}
