import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router'

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

  constructor(fb: FormBuilder, private _router: Router) {
    this.options = fb.group({
      hideRequired: false,
      floatLabel: 'auto',
    });
  }

  onSubmit() : void {  
    this._router.navigate(['/dashboard'])  
  }

}
