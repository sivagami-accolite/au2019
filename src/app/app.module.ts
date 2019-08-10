import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './../in-memory-data.service';

import { AppComponent } from './app.component';
import { EmployeeesComponent } from './../Employeees.component';
import { EmployeeDetailComponent } from './../Employee-detail.component';
import { EmployeeService } from './../Employee.service';
import { EmployeeSearchComponent } from './../Employee-search.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    EmployeeDetailComponent,
    EmployeeesComponent,
    EmployeeSearchComponent
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}