import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { LowerCasePipe } from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  confirmPassword = '';

  newUsername: String;

  usernames;

  register(user) {
    return this.authService.register(user).subscribe(
      data => this.authService.login(user.username, user.password).subscribe(
        loginData =>
          this.router.navigateByUrl('user'),
      ),
      err => {
        console.log(err),
        console.log(user);
      }
    );
  }

  compareUsernames(newUsername: String) {
    for (let i = 0; i < this.usernames.length; i++) {
      if (this.usernames[i] === newUsername.toUpperCase()) {
        return true;
      }
    }
    return false;
  }

  getAllUsers() {
    return this.userService.getAllUsernames().subscribe(
      data => {
        this.usernames = data;
        console.log(this.usernames);
      },
      error => console.log(error));
  }

  constructor(public authService: AuthService, public userService: UserService, private router: Router) { }

  ngOnInit() {
    return this.usernames = this.userService.getAllUsernames().subscribe(data => this.usernames = data);
  }

}
