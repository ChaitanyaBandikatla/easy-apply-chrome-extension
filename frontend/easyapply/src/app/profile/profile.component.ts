import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GlobalConstants } from '../global-constants';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


export class ProfileComponent implements OnInit {
  private userProfile;

  constructor (
    private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any>(GlobalConstants.backendURL + '/user/' + GlobalConstants.userID).subscribe(responseData => {
      console.log(responseData);
      this.userProfile = responseData.response;
      console.log("userProfile...", this.userProfile);
    });
  }
  
}
