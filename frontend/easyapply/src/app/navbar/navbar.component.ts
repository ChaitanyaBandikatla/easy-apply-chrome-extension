import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

/* Navigation bar component for the website */

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedin = GlobalConstants.userisLoggedin;
  constructor(private router: Router) { }

  ngOnInit(): void {
    // checking if the user is logged in every 0.1 second
    setInterval(() => {
      this.isLoggedin = GlobalConstants.userisLoggedin;
    }, 100);
  }

  // logout handler
  onLogout() {
    // updating the global constants to change the state of the application
    GlobalConstants.userisLoggedin = false;
    GlobalConstants.userID = undefined;
    // reroute to home page after logout
    this.router.navigateByUrl('home');
  }
}
