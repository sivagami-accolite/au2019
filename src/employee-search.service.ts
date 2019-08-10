import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { employee } from './employee';

@Injectable()
export class EmployeeSearchService {

  constructor(private http: Http) {
  }

  search(term: string): Observable<employee[]> {
    return this.http
        .get(`api/employeees/?name=${term}`)
        .map(response => response.json().data as employee[]);
  }
}
