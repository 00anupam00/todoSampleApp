import { Route } from '@angular/router';

import { TodosComponent } from './todos.component';

export const todosRoute: Route = {
    path: 'todos',
    component: TodosComponent,
    data: {
        pageTitle: 'Tasks'
    }
};
