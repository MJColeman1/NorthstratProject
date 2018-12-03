import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

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

  constructor(public authService: AuthService, public userService: UserService, private router: Router) { }

  ngOnInit() {
  }

}
