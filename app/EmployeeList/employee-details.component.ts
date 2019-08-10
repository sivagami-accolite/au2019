import {Component, OnInit} from '@angular/core';
import { ROUTER_DIRECTIVES, ActivatedRoute } from '@angular/router';
import {EmployeeService} from './employeeService';
import { Observable } from 'rxjs/Observable';
import {Employee, Address} from './EmployeeList/Employee';

@Component({
    selector: 'employee-details',
	templateUrl: 'app/EmployeeList/employee-details.component.html',
	providers: [EmployeeService],
    directives: [ROUTER_DIRECTIVES],
})

export class EmployeeDetailsComponent implements OnInit{

  private sub:any;
  private Address: Address;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) {
  }

ngOnInit() {
      // Subscribe to route params
      this.sub = this.route.params.subscribe(params => {
        let id = params['id'];
       // Retrieve EmployeeDetails with Id route param
        this.employeeService.findAddressById(id).subscribe(Address => this.Address = Address);
    });
  }
}