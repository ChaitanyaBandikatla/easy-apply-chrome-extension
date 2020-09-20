import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserprofileService } from '../services/userprofile.service'
import { Userprofiles } from '../services/userprofiles'
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public profiles : String[];

  constructor(private _userprofileservice:UserprofileService, private router: Router) { }

  ngOnInit(): void{
    // console.log(GlobalConstants.userID);
    this._userprofileservice.getprofiles()
      .subscribe((data: Userprofiles[]) =>{
        this.profiles = data["response"];
        if (this.profiles == 'No Job Profiles') {
          this.profiles = []
        }
      });
  }

  onCreateJobProfile(){
    this.router.navigateByUrl('jobProfile/new');
  }

  onEditJobProfile(index) {//Edit and View are the same
    console.log(index);
    // this.router.navigateByUrl('jobProfile');
  }

  onDeleteJobProfile(index) {
    //TODO: Implement Delete Job Profile
  }
}
