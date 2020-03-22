import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from "@angular/common/http"
import { User } from '../form/user';
import { UserData} from './user-data.model'
import {Observable} from 'rxjs';
import { tap, catchError, map} from 'rxjs/operators';
import { Router} from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class GetUserDataService {

  url = 'http://localhost:8080/views/demo/all'; 

  user: User;
  userData: UserData;
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };
  constructor(private http:HttpClient, private router: Router) { }
  private handleError(error: any) {    
    console.error(error);                                      
  }
  getUsers(): Observable<any>{
    return this.http.get<any>(this.url).pipe(
      tap(data => console.log(data)));
  }
  
  addUser(user:User){
    this.router.navigateByUrl('/form')
  }

  deleteUser(id:number){
    const url = `${this.url}/${id}`;

    return this.http.delete(url).pipe(
      
    ); 
    this.router.navigate(['/getuser']);

  }

  updateUser(userData:UserData): Observable<UserData>{
    const url = `${this.url}/${userData.id}`;
    return this.http.patch<UserData>(this.url, userData.id).pipe(
      map(() => this.userData)
    );
  }
}
