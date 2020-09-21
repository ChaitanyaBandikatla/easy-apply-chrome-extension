import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { GlobalConstants } from 'src/app/global-constants';

/* Edit a Job Profile handling component */

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
  
  jobProfileForm: FormGroup;
  jobProfileId = 0;
  
  // initializing this component
  ngOnInit(): void {
    // getting jobProfileId from params
    this.routeSub = this.route.params.subscribe(params => {
      this.jobProfileId = params['jobProfileId'];
    });

    this.jobProfileForm = this.formbuilder.group({
        jobProfileId: new FormControl(this.jobProfileId),
        jobProfileName: new FormControl(''),
        jobType: new FormControl(''),
        firstName: new FormControl(''),
        lastName: new FormControl(''),
        email: new FormControl(''),
        phone: new FormControl(''),
        linkedinProfile: new FormControl(''),
        githubProfile: new FormControl(''),
        website: new FormControl(''),
        informationSource: new FormControl(''),
        userId: new FormControl('')
    });

    this.http.get<any>(GlobalConstants.backendURL + '/jobProfile/' + this.jobProfileId).subscribe(responseData => {
      this.jobProfileForm.value = responseData.response;
    });
  }

  ngOnDestroy() { //prevent memory leaks
    this.routeSub.unsubscribe();
  }

  // edited form submission handler
  onSubmit() {
    this.http.patch(GlobalConstants.backendURL + "/jobProfile/edit/", this.jobProfileForm.value).subscribe(responseData => {
      console.log(responseData);
    });

    // routing back to the dashboard page after editing
    this.router.navigateByUrl('dashboard');
  }
}
