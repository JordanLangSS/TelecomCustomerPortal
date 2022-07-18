import { Component, OnInit } from '@angular/core';
import { catchError, map, Observable, of, startWith } from 'rxjs';
import { AppState } from './Response/appState';
import { DataState } from './Response/dataState';
import { CustomResponse } from './Response/responsePlans';
import { PlanService } from './service/plan.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'FrontEnd';

  //store application state in variable
  //observable type is AppState, and data to manage is CustomResponse
  appState$: Observable<AppState<CustomResponse>>;
  constructor(private planService: PlanService) {

  }

  ngOnInit(): void {

    this.appState$ = this.planService.plans$
    .pipe(
      map(response => {
        return{dataState: DataState.LOADED_STATE, appData: response}
      }),
      // while we are waiting for the response from the backend, return below
      startWith({dataState: DataState.LOADING_STATE}),
      catchError((error: string) => {
        return of({dataState: DataState.ERROR_STATE, error}) //use "of" to create observable of type AppState<CustomResponse>
      }) //string from services file
    );
  }
}
