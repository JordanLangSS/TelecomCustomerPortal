import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { PhoneNumber } from '../Response/phoneNumbers';
import { PhoneNumbersService } from '../service/phone-numbers.service';
import { SharedService } from '../service/shared.service';

@Component({
  selector: 'app-phone-numbers',
  templateUrl: './phone-numbers.component.html',
  styleUrls: ['./phone-numbers.component.css'],
})
export class PhoneNumbersComponent implements OnInit {
  public phoneNumberList: PhoneNumber[];
  public userPhoneNumberList: PhoneNumber[];
  public editPhoneNumber: PhoneNumber;
  public deletePhoneNumber: PhoneNumber;
  userId = 10;

  constructor(
    private PhoneNumbersService: PhoneNumbersService,
    private sharedService: SharedService
  ) {}

  //////////////////////////////////////////////////////////////////////////////
  public getUserPhoneNumbers(): void {
    this.PhoneNumbersService.getUserPhoneNumbers(this.userId).subscribe({
      next: (response: PhoneNumber[]) => {
        this.userPhoneNumberList = response;
        console.log(this.userId);
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      },
    });
  }
  ///////////////////////////////////////////////////////////////////////////////
  public getPhoneNumbers(): void {
    this.PhoneNumbersService.getPhoneNumber().subscribe({
      next: (response: PhoneNumber[]) => {
        this.phoneNumberList = response;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      },
    });
  }

  // use a Form to delete a phoneNumber to the backend
  public onDeleteCurrentPhoneNum(currentPhoneNumId: number): void {
    document.getElementById('delete-plan-form').click();
    this.PhoneNumbersService.deletePhoneNumber(currentPhoneNumId).subscribe({
      //void because service does not return anything
      next: (response: void) => {
        this.getPhoneNumbers(); //call getPhoneNumbers to re-update list
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  // use this to control which modal shows when a specific button is pressed
  public onOpenModal(phoneNumber: PhoneNumber, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-backdrop', 'static');
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'delete') {
      this.deletePhoneNumber = phoneNumber;
      button.setAttribute('data-bs-target', '#deletePhoneNumberModal');
    }
    container.appendChild(button);
    button.click();
  }

  async ngOnInit() {
    this.getPhoneNumbers();
    this.getUserPhoneNumbers();

    this.userId = this.sharedService.getUserId();
    console.log(this.userId);
  }
}
