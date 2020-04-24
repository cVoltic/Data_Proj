import {MatSelectModule} from '@angular/material/select';

import { Component, OnInit, Input } from '@angular/core';

import { SurveyService } from "./survey/survey.service";
import { FormGroup, FormBuilder, FormControl, Form } from '@angular/forms';
import { Validators} from "@angular/forms"
import { Router } from '@angular/router';

import {User} from './user';

interface Roles{
  value: string;
  viewValue: string; 
}
interface Projects{
  value: string;
}
interface Clients{
  value:string;
}

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  
})
export class FormComponent implements OnInit {
  
  user: User; 
  roleControl: FormControl = new FormControl();
  projectControl: FormControl = new FormControl();
  clientControl: FormControl = new FormControl();
  
  
  // TODO
  // add user function data to A
  submitted = false;
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+W\.[a-z]{2,4}$";
  
  roleList: string[] = ['GradTech Team Member', 'GradTech Lead', 'GradTech Program Member/Trainer'];
  //role='None';
  
  /*role: Roles[] = [
    {value: 'GradTech-Tech-Team-Member-0', viewValue: 'GradTech Team Member'},
    {value: 'GradTech-Lead-1', viewValue: 'GradTech Lead'},
    {value: 'GradTech-Trainer-2', viewValue: 'GradTech Trainer'}
  ];*/
  
  projects: Projects[] = [{value:'Barclay-Developement'},
                       {value:'Barclay-QA'},
                       {value:'Barclays-Tech Triage'},
                       {value:'Dupont-Machine LEarning'},
                       {value:'Dupont - RPA & Ideation Mobile App GradTech Profiles'},
                       {value:'JnJ - Raspberry Pi iOT Motion Sensing Camera App'},
                       {value:'Marlette - iOS Entech Automated Attendant'},
                       {value:'Vertex - HTML5 Virtual Attendant in AWS'}];
  
  clients: Clients[] = [{value:'Barclay'},
                        {value:'Dupont'},
                        {value:'JnJ Medical Devices'},
                        {value:'Vertex'},
                        {value:'Marlette'}];


  constructor(private surveyService:SurveyService, private route: Router) { }

  ngOnInit(): void {
    this.user = new User();
    this.roleControl.setValue(this.user);
  }


  
  onSubmit() {
    this.submitted=true;
    console.log("In the survey comopnent" + this.user.name + this.user.email)
    this.surveyService.insertUser(this.user);
    
    this.route.navigateByUrl('/confirmation')
    
  }

}
