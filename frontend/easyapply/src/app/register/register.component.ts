import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  //registerForm: FormGroup;
  constructor(
    private formbuilder: FormBuilder, 
    private http: HttpClient,  
    private router: Router) { }

  registerForm = this.formbuilder.group({
    'firstName': new FormControl(''),
    'lastName': new FormControl(''),
    'username': new FormControl(''),
    'email': new FormControl(''),
    'password': new FormControl(''),
    hideRequired: false,
    floatLabel: 'auto',
  });

  onSubmit() {
    // console.log(this.registerForm.value);
    this.router.navigateByUrl('home');
    this.http.post(GlobalConstants.backendURL + "/user", this.registerForm).subscribe(responseData => {
      console.log(responseData);
    });
  }
}