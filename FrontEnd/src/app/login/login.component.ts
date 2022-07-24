import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { User } from '../Response/user';
import * as shajs from 'sha.js';
import { UserComponent } from '../user/user.component';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  hide: boolean = true;
  user: User = new User();
  
  constructor(private fb: FormBuilder, private loginuserservice: LoginService ) { }
  

  ngOnInit(): void {
  }

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required]],
    password: ['', [Validators.required]]
  })


  onLogin() {
    this.user.username = this.loginForm.get('email').value;
    this.user.password = shajs('sha256').update(this.loginForm.get('password').value).digest('hex');
    console.log(this.user);
    this.loginuserservice.loginUser(this.user).subscribe(data=>{
      alert("Login Successfully")
    },error=>alert("Sorry, please enter correct Username and Password"));
    //console.log(shajs('sha256').update(this.loginForm.get('password').value).digest('hex'));
    //Don't submit if the entered information is not up to standard  
    if (!this.loginForm.valid) {
      return;
    }
    // if (shajs('sha256').update(this.loginForm.get('password').value).digest('hex') )
    // console.log(this.loginForm.get('email').value);
    // console.log(this.loginForm.get('password').value);
    // console.log(shajs('sha256').update(this.loginForm.get('password').value).digest('hex'));
    // console.log(this.loginForm.value); //both values together
  }

}
