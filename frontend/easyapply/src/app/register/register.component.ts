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
      'username': new FormControl('', Validators.required),
      'email': new FormControl('', [Validators.required, Validators.email]),
      'password': new FormControl('', [Validators.required, Validators.minLength(6)])
    });

  onSubmit() {
    console.log(this.registerForm.value);
  }

}
