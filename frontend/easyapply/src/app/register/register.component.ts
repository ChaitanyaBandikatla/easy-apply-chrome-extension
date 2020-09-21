import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

/* User registration (create new) component */

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
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
  });

  // registration form submission handler
  onSubmit() {
    this.http.post<any>(GlobalConstants.backendURL + "/user", this.registerForm.value).subscribe(responseData => {
      console.log(responseData);
    });
    // rerouting to home after registration/creation of user
    this.router.navigateByUrl('home');
  }
}