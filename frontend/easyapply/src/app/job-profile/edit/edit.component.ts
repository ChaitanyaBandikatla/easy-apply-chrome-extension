import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  constructor(private formbuilder: FormBuilder, private router: Router) { 
  }

  ngOnInit(): void {
    
  }

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
    this.router.navigateByUrl('home');
    //TO DO: perform Update action
  }
}
