import { Component, OnInit, Inject} from '@angular/core';
import { GetUserDataService } from './get-user-data.service';
import { User } from '../form/user'; 
import { UserData } from './user-data.model';
import { Router} from '@angular/router';



@Component({
  selector: 'app-get-user',
  templateUrl: './get-user.component.html',
  styleUrls: ['./get-user.component.css']
})
export class GetUserComponent implements OnInit{
  users:User;
  userData: UserData;
  constructor(private getUserData: GetUserDataService, private router: Router) { }

  getUser(){
    this.getUserData.getUsers().subscribe(data => {this.users=data})
  }
  ngOnInit(): void {
    this.getUser();
  }
  
  addUser(){
    this.router.navigateByUrl('/form');
  }
  
  idtodelete=1;

  
  deleteUser(userData: User) {
    this.getUserData.deleteUser(userData.id).subscribe(data => {
       this.getUser();
    });
  console.log('Deleted');
  
    this.refresh();




  }
  idtoUpdate = 1;
  updateUser() {
    this.getUserData.getUsers().subscribe(data => {
      this.users = data;
      this.getUserData.updateUser(this.userData).subscribe(data1 => {
        this.getUser();
      });
    });
  }
  
  refresh(): void {
    window.location.reload();
}
}
