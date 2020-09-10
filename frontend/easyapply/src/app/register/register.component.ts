import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  //registerForm: FormGroup;
  constructor(private formbuilder: FormBuilder) { }

  registerForm = this.formbuilder.group({
    'firstname': new FormControl('', Validators.required),
    'middlename': new FormControl('', Validators.required),
    'lastname': new FormControl('', Validators.required),
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
    console.log(this.registerForm.value);
  }
}