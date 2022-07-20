import { DataSource } from '@angular/cdk/collections';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { Plan } from '../Response/plans';
import { PlanService } from '../service/plan.service';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})

export class BillingComponent implements OnInit {

  //dataSource = new PlanDataSource(this.planService)
  //initialize and pass planService Object
  // dataSource = new MatTableDataSource<Plan>();
  // displayedColumns: string[] = ['name', 'deviceLimit', 'price'];
  // constructor(private planService: PlanService) {}

  
  public plansList: Plan[];
  constructor(private planService: PlanService) {}

  public getPlans(): void {
    this.planService.getPlans().subscribe(
      (response: Plan[]) => {
        this.plansList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  ngOnInit(): void {
    this.getPlans();
    // this.planService.getPlans().subscribe(
    //   data => this.dataSource.data = data
    //   );
  }

}
// export class PlanDataSource extends DataSource<any> {
//   constructor(private planService: PlanService) {
//     super();
//    }
//   connect(): Observable<Plan[]> {
//     // return observable of type Plan[]
//     return this.planService.getPlans();
//   }
//   disconnect() {}
// }

