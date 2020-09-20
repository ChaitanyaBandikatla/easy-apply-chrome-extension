import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

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

  onSubmit() {
    this.http.post<any>(GlobalConstants.backendURL + "/user", this.registerForm.value).subscribe(responseData => {
      console.log(responseData);
    });
    this.router.navigateByUrl('home');
  }
}