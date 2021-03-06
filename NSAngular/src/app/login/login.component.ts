import { Component, OnInit} from '@angular/core';
import { AuthService } from '../auth.service';
import { UserComponent } from '../user/user.component';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();



  login = function(user) {
    // Subscribe to authService passing in the form username and password
    this.authService.login(user.username, user.password).subscribe(
      // On success log in and route back to posts
      data => {
        console.log(user);
        if (user.username === 'admin') {
          this.router.navigateByUrl('admin');
        } else {
          this.router.navigateByUrl('user');
        }
      // If error return this instead
      },
      err => {
          alert('Invalid username and/or password. Please enter valid credentials.');
      }
    );
  };
  constructor(public authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

}
