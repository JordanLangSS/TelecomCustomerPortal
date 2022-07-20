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
  public editPlan: Plan; //plan the user clicking on to add to their current plans

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

  // use a Form to add a plan to the backend
  public onAddPlan(plan: Plan): void {
    document.getElementById("add-plan-form").click();
    this.planService.addPlan(plan).subscribe(
      (response: Plan) => {
        console.log(response);
        this.getPlans();
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    )
  }

  public onOpenModal(plan: Plan, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-backdrop', 'false');
    //open the add modal if the user clicks the "add now" button
    if (mode === 'add') {
      this.editPlan = plan;
      button.setAttribute('data-target', '#addModal');
    }
    // Open the Delete Modal if the user clicks the delete button
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deletePlanModal');
    }
    container.appendChild(button);
    button.click();
  }

  ngOnInit(): void {
    this.getPlans();

  }

}
