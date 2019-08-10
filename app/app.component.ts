import { Component, NgModule }         from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {Http, Response} from '@angular/http';
import {EmployeeList} from './EmployeeList/employee-list.component'

@Component({
  selector: 'my-app',
  template: `
	<router-outlet></router-outlet>
  `,
  directives: [ROUTER_DIRECTIVES]
})
export class AppComponent { }