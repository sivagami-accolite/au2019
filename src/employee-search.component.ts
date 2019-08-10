import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { employeeSearchService } from './employee-search.service';
import { employee } from './employee';

@Component({
  selector: 'employee-search',
  templateUrl: './employee-search.component.html',
  styleUrls: ['./employee-search.component.css'],
  providers: [employeeSearchService]
})
export class EmployeeSearchComponent implements OnInit {
  employeees: Observable<employee[]>;
  private searchTerms = new Subject<string>();

  constructor(private employeeSearchService: employeeSearchService,
              private router: Router) {
  }

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.employeees = this.searchTerms
        .debounceTime(300)        // wait 300ms after each keystroke before considering the term
        .distinctUntilChanged()   // ignore if next search term is same as previous
        .switchMap(term => term   // switch to new observable each time the term changes
            // return the http search observable
            ? this.employeeSearchService.search(term)
            // or the observable of empty employeees if there was no search term
            : Observable.of<employee[]>([]))
        .catch(error => {
          // TODO: add real error handling
          console.log(error);
          return Observable.of<employee[]>([]);
        });
  }

  gotoDetail(employee: employee): void {
    let link = ['/detail', employee.id];
    this.router.navigate(link);
  }
}
