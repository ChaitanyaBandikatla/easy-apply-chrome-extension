import { Component, OnInit } from '@angular/core';
import { UserprofileService } from '../services/userprofile.service'
import { Userprofiles } from '../services/userprofiles'
import { Router } from '@angular/router';

/* Dashboard of a User */

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public profiles : String[];

  constructor(private _userprofileservice:UserprofileService, private router: Router) { }

  // runs as initialization
  ngOnInit(): void {
    this._userprofileservice.getprofiles()
      .subscribe((data: Userprofiles[]) =>{
        this.profiles = data["response"];
        if (this.profiles == 'No Job Profiles') {
          this.profiles = []
        }
      });
  }

  // job profile creation handler
  onCreateJobProfile(){
    this.router.navigateByUrl('jobProfile/new');
  }

  // job profile editing handler
  onEditJobProfile(index) {//Edit and View are the same
    this.router.navigateByUrl('jobProfile/' + this.profiles[index].jobProfileId + '/edit');
  }

  // job profile deletion handler
  onDeleteJobProfile(index) {
    //TODO: Implement Delete Job Profile
  }
}
