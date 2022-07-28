import { Injectable } from '@angular/core';
import { User } from '../Response/user';
import { LoginService } from './login.service';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private isloggedIn: boolean;
  user: User = new User();

  constructor(private loginuserService: LoginService) {
    this.isloggedIn=false;
   }

   login(userName: string, password: string){
    this.user.userName = userName;
    this.user.password = password;
    console.log(this.user);
    this.loginuserService.loginUser(this.user).subscribe(data=>{
      this.isloggedIn=true;
      console.log(data);
      const id = data;
      console.log(id);
      alert("Login Successful");
      return of(this.isloggedIn);
      
    },error=>alert("Sorry, please enter correct Username and Password"));
   }

   isUserLoggedIn(): boolean{
    return this.isloggedIn;
   }

   logoutUser(): void{
    this.isloggedIn = false;
}
}
