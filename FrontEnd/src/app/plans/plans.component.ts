import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
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
  public deletePlan: Plan; //delete plan when the user clicks delete

  constructor(private planService: PlanService) {}

  public getPlans(): void {
    this.planService.getPlans().subscribe({
      next: (response: Plan[]) => {
        this.plansList = response;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    });
  }

  // use a Form to add a plan to the backend
  public onAddPlan(plan: Plan): void {
    document.getElementById("add-plan-form").click();
    this.planService.addPlan(plan).subscribe({
      next: (response: Plan) => {
        console.log(response);
        this.getPlans(); //call getPlans to re-update list
        
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    });
  }

    // use a Form to add a plan to the backend
    public onDeletePlan(planId: number): void {
      document.getElementById("delete-plan-form").click();
      this.planService.deletePlan(planId).subscribe({
        //void because service does not return anything
        next: (response: void) => { 
          console.log(response);
          this.getPlans(); //call getPlans to re-update list
          
        },
        error: (error: HttpErrorResponse) => {
          console.log(error.message);
          alert(error.message);
        }
      });
    }


  public onOpenModal(plan: Plan, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement("button");
    button.type = "button";
    button.style.display = "none";
    button.setAttribute("data-backdrop","static");
    button.setAttribute("data-bs-toggle", "modal");
    
    //open the add modal if the user clicks the "add now" button
    if (mode === "add") {
      this.editPlan = plan;
      button.setAttribute('data-bs-target', '#addModal');
    }
    // Open the Delete Modal if the user clicks the delete button
    if (mode === "delete") {
      this.deletePlan = plan;
      button.setAttribute("data-bs-target", "#deletePlanModal");
    }
    container.appendChild(button);
    button.click();
  }

  

  async ngOnInit() {
    this.getPlans();

  }

}
