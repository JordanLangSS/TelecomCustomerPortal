import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide: boolean = true;
  
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  })


  onLogin() {
    //Don't submit if the entered information is not up to standard  
    if (!this.loginForm.valid) {
      return;
    }
    console.log(this.loginForm.get('email').value);
    console.log(this.loginForm.get('password').value);
    console.log(this.loginForm.value); //both values together
  }

}
