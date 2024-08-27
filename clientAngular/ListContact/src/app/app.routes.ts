import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./list-contact/list-contact.component')
    },
    {
        path: 'new',
        loadComponent: () => import('./contac-form/contac-form.component') 
    },
    {
        path: ':id/edit',
        loadComponent: () => import('./contac-form/contac-form.component') 
    },
];
