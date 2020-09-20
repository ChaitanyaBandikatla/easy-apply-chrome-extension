import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserprofileService } from '../services/userprofile.service'
import { Userprofiles } from '../services/userprofiles'
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public profiles : String[];

  constructor(private _userprofileservice:UserprofileService, private router: Router) { }

  ngOnInit(): void{
    this._userprofileservice.getprofiles()
      .subscribe((data: Userprofiles[]) =>{
        this.profiles = data["response"];
        if (this.profiles == 'No Job Profiles') {
          this.profiles = []
        }
        // console.log(this.profiles);
      });
  }

  onCreateJobProfile(){
    //TODO: create new job profile
  }
  onEditJobProfile() {
    //TODO: Route to the edit page of job profile
    // this.router.navigateByUrl('');
  }
  onDeleteJobProfile() {
    //TODO: Implement Delete Job Profile
  }
}
