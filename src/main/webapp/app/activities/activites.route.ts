import { Routes } from '@angular/router';

import {
    todosRoute
} from './';

import { UserRouteAccessService } from '../shared';

const ADMIN_ROUTES = [
    todosRoute
    ];

export const adminState: Routes = [{
    path: '',
    data: {
        authorities: ['ROLE_ADMIN']
    },
    canActivate: [UserRouteAccessService],
    children: ADMIN_ROUTES
},
    todosRoute
];
