import { Injectable } from '@angular/core';
import { User } from '../Response/user';
import { LoginService } from './login.service';
import * as shajs from 'sha.js';
import { of } from 'rxjs';
import { SharedService } from './shared.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  id: number;

  private isloggedIn: boolean;
  user: User = new User();

  constructor(
    private loginuserService: LoginService,
    private sharedService: SharedService
  ) {
    this.isloggedIn = false;
  }

  login(userName: string, password: string) {
    this.user.userName = userName;
    this.user.password = password;
    this.loginuserService.loginUser(this.user).subscribe(
      (data) => {
        this.isloggedIn = true;

        //pass the userId to the other components to use
        this.sharedService.setUserId(data);

        alert('Login Successful');
        return of(this.isloggedIn);
      },
      (error) => {
        alert('Sorry, please enter correct Username and Password');
      }
    );
  }

  isUserLoggedIn(): boolean {
    return this.isloggedIn;
  }

  logoutUser(): void {
    this.isloggedIn = false;
  }
}
