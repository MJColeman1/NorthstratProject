import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  canActivate() {
    if (this.authService.checkLogin()) {
    return true;
    }
    this.router.navigateByUrl('login');
    return false;
    }

  constructor(private authService: AuthService, private router: Router) { }
}
