import {Component, OnInit} from '@angular/core';
import { ROUTER_DIRECTIVES, ActivatedRoute } from '@angular/router';
import {EmployeeService} from './employeeService';
import { Observable } from 'rxjs/Observable';
import { FormsModule } from '@angular/forms';
import {NgForm}    from 'angular2/common';

@Component({
	selector: 'employee-Edit',
	templateUrl: 'app/EmployeeList/edit.component.html',
	providers: [EmployeeService],
    directives: [ROUTER_DIRECTIVES],
})

export class EditComponent implements OnInit{

  private sub:any;
  employee: Employee;
  success: boolean = false;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) {
  }

ngOnInit() {
		this.sub = this.route.params.subscribe(params => {
        let id = params['id'];
        this.employeeService.ShowEmployee(id).subscribe(Employee => this.employee = Employee);
    });
  }

SaveEdit():void{
	this.employeeService.SaveEmployee(this.employee).subscribe(success => {
         // refresh the list
		 this.success = true;
       });
}
}