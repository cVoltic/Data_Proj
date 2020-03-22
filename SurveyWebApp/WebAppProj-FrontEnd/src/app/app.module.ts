import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatSelectModule} from'@angular/material/select';

import { HttpClientModule } from "@angular/common/http";


import { AppComponent } from './app.component';

import { FormComponent } from './form/form.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';

import { SurveyService} from './form/survey/survey.service';
import { GetUserComponent } from './get-user/get-user.component'
import { LoginComponent } from './login/login.component'
import { AuthGuard } from './login/_guards/auth.guard';

export const appRoutes : Routes = [
  {path:'form', component:FormComponent},
  {path:'confirmation',component:ConfirmationComponent},
  //access to only admincanActivate:[ AuthGuard ]
  {path:'getuser', component:GetUserComponent, },
  
  
  {path:'login', component:LoginComponent},

  {path: '', redirectTo:'/form',pathMatch:'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    AdminPageComponent,
    ConfirmationComponent,
    GetUserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    MatFormFieldModule, 
    MatSelectModule,
     
    
  ],
  providers: [SurveyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
