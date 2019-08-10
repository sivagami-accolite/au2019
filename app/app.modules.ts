import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import { ModalModule } from 'angular2-modal';
import { BootstrapModalModule } from 'angular2-modal/plugins/bootstrap';
import { FormsModule } from '@angular/forms';
import { AppComponent }   from './app.component';
import {EmployeeList} from './EmployeeList/employee-list.component';
import { routing } from './app.routes';
import {EmployeeDetailsComponent} from './EmployeeList/employee-details.component';
import {EditComponent} from './EmployeeList/edit.component';

@NgModule({
  imports: [ 
    BrowserModule, 
    ModalModule.forRoot(),
    BootstrapModalModule,
	HttpModule,
	routing,
	FormsModule
  ],
  declarations: [ AppComponent, EmployeeList, EmployeeDetailsComponent, EditComponent ],
  bootstrap:    [ AppComponent ],
 
})
export class AppModule { }