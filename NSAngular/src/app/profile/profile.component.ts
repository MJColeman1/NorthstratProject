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

  constructor(private userService: UserService, private router: Router, private authService: AuthService) { }

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data);

  updateUser(user: User) {
    return this.userService.updateUser(user).subscribe(
      data => {
      },
      error => console.log(error + ' Kaboom in update user profile component'));
  }

  loginAfterUpdate(user) {
    this.updateUser(user);
    // Subscribe to authService passing in the form username and password
    // On success log in and route back to posts
    // If error return this instead
    this.authService.login(user.username, user.password), this.router.navigateByUrl('login');
  }

  ngOnInit() {
  }

}
