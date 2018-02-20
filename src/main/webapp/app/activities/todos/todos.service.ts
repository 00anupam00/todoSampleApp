import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Todo } from './todo.model';

@Injectable()
export class TodosService {
    constructor(private http: HttpClient) { }

    changeLevel(todo: Todo): Observable<HttpResponse<any>> {
        return this.http.put(SERVER_API_URL + 'todos', todo, {observe: 'response'});
    }

    findAll(): Observable<HttpResponse<Todo[]>> {
        return this.http.get<Todo[]>(SERVER_API_URL + 'todos', {observe: 'response'});
    }
}
