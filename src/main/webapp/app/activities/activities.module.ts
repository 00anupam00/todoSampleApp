import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TodoSampleAppSharedModule } from '../shared';


import {
    TodosComponent,
    TodosService,
} from "./";

@NgModule({
    imports:[
        TodoSampleAppSharedModule,
    ],
    declarations:[
        TodosComponent
    ],
    providers:[
        TodosService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TodoSampleAppActivitiesModule {}
