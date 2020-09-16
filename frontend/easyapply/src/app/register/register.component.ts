import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { GlobalConstants } from '../global-constants';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  //registerForm: FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient) { }

  registerForm = this.formbuilder.group({
    'firstName': new FormControl('', Validators.required),
    'lastName': new FormControl('', Validators.required),
    'username': new FormControl('', Validators.required),
    'email': new FormControl('', [Validators.required, Validators.email]),
    'password': new FormControl('', [Validators.required, Validators.minLength(6)]),
    hideRequired: false,
    floatLabel: 'auto',
  });

  public registerFormErrors = (controlName: string, errorName: string) => {
    return this.registerForm.controls[controlName].hasError(errorName);
  }

  onSubmit() {
    // console.log(this.registerForm.value);
    this.http.post(GlobalConstants.backendURL + "/user", this.registerForm).subscribe(responseData => {
      console.log(responseData);
    });
  }
}