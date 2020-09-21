import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router'
import { GlobalConstants } from '../global-constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hide = true;
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

  onSubmit() : void {  
    // this._router.navigate(['/dashboard'])
    this.http.post<any>(GlobalConstants.backendURL + '/user/login', this.loginForm.value).subscribe(response => {
      // console.log(response.response.userId);
      if (response.httpStatus == 'OK') {
        GlobalConstants.userID = response.response.userId;
        GlobalConstants.userisLoggedin = true;
        this.loginFailed = false;
        this._router.navigateByUrl('dashboard');
      } else {
        this.loginFailed = true;
      }
    });
  }

}
