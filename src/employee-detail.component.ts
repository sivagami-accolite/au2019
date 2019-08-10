import 'rxjs/add/operator/switchMap';
import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { employee }        from './employee';
import { employeeService } from './employee.service';

@Component({
  selector: 'employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: [ './employee-detail.component.css' ]
})
export class EmployeeDetailComponent implements OnInit {
  employee: employee;

  constructor(
    private employeeService: employeeService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.employeeService.getemployee(+params.get('id')))
      .subscribe(employee => this.employee = employee);
  }

  save(): void {
    this.employeeService.update(this.employee)
      .then(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}
