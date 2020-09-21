import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder,FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router'
import { GlobalConstants } from '../global-constants';

/* User Login handling component */

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  username = new FormControl(''); 
  password = new FormControl(''); 
  options: FormGroup;
  loginFailed = false;

  constructor(private fb: FormBuilder, private _router: Router, private http: HttpClient) {
    this.options = fb.group({
      hideRequired: false,
      floatLabel: 'auto',
    });
  }

  loginForm = this.fb.group({
    'username': new FormControl(''),
    'password': new FormControl('')
  });

  // login form submission handler
  onSubmit() : void {
    this.http.post<any>(GlobalConstants.backendURL + '/user/login', this.loginForm.value).subscribe(response => {
      if (response.httpStatus == 'OK') {
        // updating the global constants state
        GlobalConstants.userID = response.response.userId;
        GlobalConstants.userisLoggedin = true;
        this.loginFailed = false;
        // rerouting to dashboard of the user after successful login
        this._router.navigateByUrl('dashboard');
      } else {
        this.loginFailed = true;
      }
    });
  }

}
