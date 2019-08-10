import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { employeeesComponent } from './../employeees.component';
import { employeeDetailComponent } from './../employee-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/employeees', pathMatch: 'full' },
  { path: 'detail/:id', component: EmployeeDetailComponent },
  { path: 'employeees', component: EmployeeesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
