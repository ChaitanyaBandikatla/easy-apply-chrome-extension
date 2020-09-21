import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/* Main App Component */

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'easyapply';
  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.navigateByUrl('login');
  }
}
