import { Injectable } from '@angular/core';
import { Userprofiles } from './userprofiles';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { GlobalConstants } from '../global-constants';

/* Services for Profile component */

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  constructor(private http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // GET operation method for User Profiles
  public getprofiles() : Observable<Userprofiles[]>{
    return this.http.get<Userprofiles[]>(GlobalConstants.backendURL + '/userJobProfile/' + GlobalConstants.userID).pipe(
      retry(1),
      catchError(this.errorHandl)
    );
  }

  // error handler
  errorHandl(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }
}
