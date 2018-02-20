import { Component, OnInit } from '@angular/core';

import { Todo } from './todo.model';
import { TodosService } from './todos.service';

@Component({
    selector: 'jhi-todos',
    templateUrl: './todos.component.html',
})
export class TodosComponent implements OnInit {

    todos: Todo[];
    filter: string;
    orderProp: string;
    reverse: boolean;

    constructor(
        private todoService: TodosService
    ) {
        this.filter = '';
        this.orderProp = 'name';
        this.reverse = false;
    }

    ngOnInit() {
        this.todoService.findAll().subscribe((response) => this.todos = response.body);
    }

    changeLevel(desc: string, status: string) {
        const todo = new Todo(desc, status);
        this.todoService.changeLevel(todo).subscribe(() => {
            this.todoService.findAll().subscribe((response) => this.todos = response.body);
        });
    }
}
