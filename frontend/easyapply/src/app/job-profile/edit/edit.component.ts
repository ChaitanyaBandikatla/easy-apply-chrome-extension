import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  private routeSub: Subscription;
  constructor(
    private formbuilder: FormBuilder, 
    private router: Router, 
    private http: HttpClient,
    private route: ActivatedRoute) {
  }

  jobProfileId = 0;
  jobProfileForm = this.formbuilder.group({
      id: new FormControl(this.jobProfileId),
      jobProfileName: new FormControl('', Validators.required),
      firstname: new FormControl('', Validators.required),
      middlename: new FormControl(''),
      lastname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
      linkedinProfile: new FormControl(''),
      website: new FormControl(''),
  });

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      console.log(params) //log the entire params object
      console.log(params['id']) //log the value of id
      this.jobProfileId = params['id'];
    });

    this.http.get<any>('http://localhost:8080/jobProfile/' + this.jobProfileId).subscribe(responseData => {
      // console.log(responseData);
      this.jobProfileForm = responseData.response;
    });
  }

  ngOnDestroy() { //prevent memory leaks
    this.routeSub.unsubscribe();
  }

  onSubmit() {
    // console.log(this.jobProfileForm.value);
    this.http.patch("http://localhost:8080/jobProfile/edit", this.jobProfileForm).subscribe(responseData => {
      console.log(responseData);
    });
    this.router.navigateByUrl('home');
    //TO DO: perform Update action
  }
}
