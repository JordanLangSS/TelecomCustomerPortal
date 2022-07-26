import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { User } from '../Response/user';
import * as shajs from 'sha.js';
import { UserComponent } from '../user/user.component';
import { LoginService } from '../service/login.service';
import { AuthService } from '../service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  hide: boolean = true;
  user: User = new User();
  
  constructor(private fb: FormBuilder, private loginuserservice: LoginService, private authService: AuthService ) { }
  

  ngOnInit(): void {
  }

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required]],
    password: ['', [Validators.required]]
  })


  onLogin() {
    
     this.user.userName = this.loginForm.get('email').value;
     this.user.password = shajs('sha256').update(this.loginForm.get('password').value).digest('hex');
     const userName = this.user.userName;
     const password = this.user.password;
     this.authService.login(userName, password);
    // console.log(this.user);
    // this.loginuserservice.loginUser(this.user).subscribe(data=>{
    //   alert("Login Successfully")
    //   const loginKey = this.user;
    //   console.log(loginKey);
    //   return loginKey;
    // },error=>alert("Sorry, please enter correct Username and Password"));
    // //console.log(shajs('sha256').update(this.loginForm.get('password').value).digest('hex'));
    // //Don't submit if the entered information is not up to standard  
    // if (!this.loginForm.valid) {
    //   return;
    // }
    // if (shajs('sha256').update(this.loginForm.get('password').value).digest('hex') )
    // console.log(this.loginForm.get('email').value);
    // console.log(this.loginForm.get('password').value);
    // console.log(shajs('sha256').update(this.loginForm.get('password').value).digest('hex'));
    // console.log(this.loginForm.value); //both values together
  }

}
