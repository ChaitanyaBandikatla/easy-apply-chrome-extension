import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalConstants } from '../global-constants';

/* Navigation bar for the user to select */

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedin = GlobalConstants.userisLoggedin;
  constructor(private router: Router) { }

  ngOnInit(): void {
    setInterval(() => {
      this.isLoggedin = GlobalConstants.userisLoggedin;
    }, 100);
  }

  onLogout() {
    GlobalConstants.userisLoggedin = false;
    GlobalConstants.userID = undefined;
    this.router.navigateByUrl('home');
  }
}
