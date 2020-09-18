import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserprofileService } from '../services/userprofile.service'
import { Userprofiles } from '../services/userprofiles'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public profiles : String[];

  constructor(private _userprofileservice:UserprofileService) { }

  ngOnInit(): void{
    this._userprofileservice.getprofiles()
      .subscribe((data: Userprofiles[]) =>{
        this.profiles=data["response"];
        console.log(this.profiles);
      })
  }

}
