import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { employee } from './employe';
import { employeeService } from './employee.service';

@Component({
  selector: 'my-employeees',
  templateUrl: './employeees.component.html',
  styleUrls: ['./employeees.component.css']
})
export class EmployeeesComponent implements OnInit {
  employeees: employee[];
  selectedemployee: employee;

  constructor(private employeeService: employeeService,
              private router: Router) {
  }

  getemployeees(): void {
    this.employeeService
        .getemployeees()
        .then(employeees => this.employeees = employeees);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.employeeService.create(name)
        .then(employee => {
          this.employeees.push(employee);
          this.selectedemployee = null;
        });
  }

  delete(employee: employee): void {
    this.employeeService
        .delete(employee.id)
        .then(() => {
          this.employeees = this.employeees.filter(h => h !== employee);
          if (this.selectedemployee === employee) {
            this.selectedemployee = null;
          }
        });
  }

  ngOnInit(): void {
    this.getemployeees();
  }

  onSelect(employee: employee): void {
    this.selectedemployee = employee;
        this.router.navigate(['/detail', this.selectedemployee.id]);

  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedemployee.id]);
  }
}
