import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { Plan } from '../Response/plans';
import { CustomResponse } from '../Response/responsePlans';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
 private readonly apiUrl = 'http://localhost:8080';

  // inject Http Client
  //use HttpClient to make a call to the backend to get data
  //map data to app state
  constructor(private http: HttpClient) { }

  //define an observable (use $ to not this)
  plans$ = <Observable<CustomResponse>>
  this.http.get<CustomResponse>(`${this.apiUrl}/plan/list`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  save$ = (plan: Plan) => <Observable<CustomResponse>>
  this.http.post<CustomResponse>(`${this.apiUrl}/plan/save`, plan)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

  delete$ = (planId: number) => <Observable<CustomResponse>>
  this.http.delete<CustomResponse>(`${this.apiUrl}/plan/delete/${planId}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  )

 //MAYBE ADD A FILTER???? 01:30:00
//  filter$ = (planType: someEnum, response: CustomResponse) => <Observable<CustomResponse>>
// new Observable<CustomResponse>(
//   subscriber => {
//     console.log(Response);
//     subscriber.next(
//       planType === SVGComponentTransferFunctionElement.ALL ? {...Response, message: `Filtered by ${planType} type`} :
//       {
//         ...response,
//         message: response.data.planType?
//         .filter(planType => planType.status === planType).length > 0 ? `filtered` : `no plans to filter`,
//         data: { planType: response.data.planType
//         .filter(planType => planType.status === planType)}
//       }
//     );
//     subscriber.complete();
//   }
// )
//  .pipe(
//    tap(console.log),
//    catchError(this.handleError)
//  )



  //maybe put dev message here???
  private handleError(error: HttpErrorResponse): Observable<never> {
    //for debugging
    console.log(error);
    return throwError(`An error occurred: ${error.status}`);
  }


  //define a method to retrieve all of the plans
  // getPlans(): Observable<CustomResponse> {
  //   return this.http.get<CustomResponse>(`http://localhost:8080/plan/list`);
  // }
}
