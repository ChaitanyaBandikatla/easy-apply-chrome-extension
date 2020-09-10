import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent {
  //jobProfileForm: FormGroup;

  constructor(private formbuilder: FormBuilder) { }

  jobProfileForm = this.formbuilder.group({
      jobProfileName: new FormControl('', Validators.required),
      firstname: new FormControl('', Validators.required),
      middlename: new FormControl(''),
      lastname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
      linkedinProfile: new FormControl(''),
      website: new FormControl(''),
    });

  onSubmit() {
    console.log(this.jobProfileForm.value);
  }
}
