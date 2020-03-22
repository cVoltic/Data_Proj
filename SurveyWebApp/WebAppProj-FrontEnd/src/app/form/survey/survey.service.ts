
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs'
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {

  url = 'http://localhost:8080/views/demo/add';

  constructor(private http:HttpClient) { }
  
  insertUser(user: User){
    console.log("User survey data " + JSON.stringify(user));
    

    /*let httpParams = new HttpParams().append("name", user.name)
				.append("email", user.email)
				.append("college", user.college)
				.append("degree", user.degree)
				.append("role", user.roles)
				.append("project", user.project)
				.append("client", user.client)
				.append("fun_fact1", user.fun_fact1)
				.append("fun_fact2", user.fun_fact2);
    */

    var JSVar = JSON.parse(JSON.stringify(user));
    console.log("Json var: " + JSVar)
    return this.http.post(this.url, JSVar).subscribe(
      res =>{
        console.log(res);
      }, 
      err => {
        console.log(err);
      }
    ); 
  }   
}
