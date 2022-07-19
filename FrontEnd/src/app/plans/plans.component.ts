import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Plan } from '../Response/plans';
import { PlanService } from '../service/plan.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {

  public plansList: Plan[];
  
  constructor(private planService: PlanService) { }

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
  }

}
