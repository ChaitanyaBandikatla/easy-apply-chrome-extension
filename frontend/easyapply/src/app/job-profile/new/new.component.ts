import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent {
  //jobProfileForm: FormGroup;
  constructor(
    private formbuilder: FormBuilder, 
    private router: Router,
    private http: HttpClient) { 
  }

  jobProfileForm = this.formbuilder.group({
      jobProfileName: new FormControl(''),
      firstname: new FormControl(''),
      middlename: new FormControl(''),
      lastname: new FormControl(''),
      email: new FormControl(''),
      phone: new FormControl(''),
      linkedinProfile: new FormControl(''),
      website: new FormControl(''),
    });

  onSubmit() {
    // console.log(this.jobProfileForm.value);
    this.router.navigateByUrl('home');
    this.http.post('http://localhost:8080/jobProfile', this.jobProfileForm).subscribe(responseData => {
      console.log(responseData);
    });
  }
}
