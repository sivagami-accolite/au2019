import { Routes } from '@angular/router';

import { EmployeeList }    from './employee-list.component';
import { EmployeeDetailsComponent }    from './employee-details.component';
import { EditComponent } from './edit.component';

// Route Configuration
export const EmployeeRoutes: Routes = [
  { path: 'employees', component: EmployeeList },
  { path: 'employee/:id', component: EmployeeDetailsComponent },
  { path: 'edit/:id', component: EditComponent }
];