import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  loggedInUser = this.userService.getUser().subscribe(data => this.loggedInUser = data.username);

  username = '';

  getLoggedInUser(): string {
    this.username = atob(localStorage.getItem('token')).split(':')[0];
    return this.username;
  }

  constructor(public authService: AuthService, private userService: UserService) { }

  ngOnInit() {
    console.log(this.username);
    return this.loggedInUser;
  }

}
