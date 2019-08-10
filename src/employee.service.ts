import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {employee} from './employee';

@Injectable()
export class EmployeeService {
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private employeeesUrl = '/api/employeees';  // URL to web api

  constructor(private http: Http) {
  }

  getemployeees(): Promise<employee[]> {
    return this.http.get(this.employeeesUrl)
        .toPromise()
        .then(response => response.json().data as employee[])
        .catch(this.handleError);
  }


  getemployee(id: number): Promise<employee> {
    const url = `${this.employeeesUrl}/${id}`;
    return this.http.get(url)
        .toPromise()
        .then(response => response.json().data as employee)
        .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.employeeesUrl}/${id}`;
    return this.http.delete(url, { headers: this.headers })
        .toPromise()
        .then(() => null)
        .catch(this.handleError);
  }

  create(name: string): Promise<employee> {
    return this.http
        .post(this.employeeesUrl, JSON.stringify({ name: name }), { headers: this.headers })
        .toPromise()
        .then(res => res.json().data as employee)
        .catch(this.handleError);
  }

  update(employee: employee): Promise<employee> {
    const url = `${this.employeeesUrl}/${employee.id}`;
    return this.http
        .put(url, JSON.stringify(employee), { headers: this.headers })
        .toPromise()
        .then(() => employee)
        .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}

