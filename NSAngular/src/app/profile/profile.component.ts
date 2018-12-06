import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  confirmPassword = '';

  constructor(private userService: UserService, private router: Router, private authService: AuthService) { }

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  updateUser(user: User) {
    return this.userService.updateUser(user).subscribe(
      data => {
        this.router.navigateByUrl('user');
      },
      error => console.log(error + ' Kaboom in update user profile component'));
  }

  loginAfterUpdate(user) {
    this.userService.updateUsernameAndPassword(user).subscribe(
      data => {
        this.authService.logout();
        this.router.navigateByUrl('login');
      },
      error => console.log(error + ' kaboom in update password profile component'));
  }

  ngOnInit() {
  }

}
