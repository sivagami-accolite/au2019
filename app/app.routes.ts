import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EmployeeRoutes }    from './EmployeeList/employee.routes';

// Route Configuration
export const routes: Routes = [
  {
    path: '',
    redirectTo: '/employees',
    pathMatch: 'full'
  },
    // Add dog routes form a different file
  ...EmployeeRoutes
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
