import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  greeting = 'Hello World';

  users = [];

  user: User = new User();

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  reload() {
    return this.loggedInUser;
  }

  createUser() {
    return this.userService.createUser(this.user).subscribe(
      data => {
      this.user = new User();
      this.reload();
      },
      error => console.log('Kaboom in create user component'));
  }

  updateUser(id: number, user: User) {
    this.userService.updateUser(id, user).subscribe(
      data => {
        this.reload();
      },
      error => console.log(error + 'Kaboom in update user component'));
  }

  constructor(private userService: UserService, public authService: AuthService) { }

  ngOnInit() {
    return this.loggedInUser;
  }

}
