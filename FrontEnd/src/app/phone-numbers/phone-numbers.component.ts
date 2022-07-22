import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { PhoneNumber } from '../Response/phoneNumbers';
import {PhoneNumbersService} from '../service/phone-numbers.service';

@Component({
  selector: 'app-phone-numbers',
  templateUrl: './phone-numbers.component.html',
  styleUrls: ['./phone-numbers.component.css']
})
export class PhoneNumbersComponent implements OnInit {

  public phoneNumberList: PhoneNumber[];
  public editPhoneNumber: PhoneNumber;
  public deletePhoneNumber: PhoneNumber;
  constructor(private PhoneNumbersService: PhoneNumbersService) { }


  public getPhoneNumbers(): void {
    this.PhoneNumbersService.getPhoneNumber().subscribe({
      next: (response: PhoneNumber[]) => {
        this.phoneNumberList = response;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    });
  }


  async ngOnInit() {
    this.getPhoneNumbers();
  }

}
