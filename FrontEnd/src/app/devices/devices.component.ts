import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CurrentDevices } from '../Response/currentDevices';
import { Devices } from '../Response/devices';
import { CurrentDevicesService } from '../service/current-devices.service';
import { DevicesService } from '../service/devices.service';
import { SharedService } from '../service/shared.service';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { PhoneNumbersService } from '../service/phone-numbers.service';
import { PhoneNumber } from '../Response/phoneNumbers';
@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})

export class DevicesComponent implements OnInit {

  constructor(private fb: FormBuilder, private DevicesService: DevicesService, private CurrentDevicesService: CurrentDevicesService, private sharedService: SharedService, private PhoneNumbersService: PhoneNumbersService) {}
  

  
  nullValue = null;

  addFormGroup: FormGroup = this.fb.group({
    make: [''],
    model: [''],
    phoneNumbers: this.fb.group({
      phoneNumber: [null, [ Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]], 
    })
  })

  editFormGroup: FormGroup = this.fb.group({
    id: [''],
    make: [''],
    model: [''],
    phoneNumbers: this.fb.group({
      id: [''],
      phoneNumber: [null, [ Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]], 
    })
  })


  deviceLimit: number; // use to retrieve from the plans table component
  numDevices: number

  public devicesList: Devices[];
  public currentDevicesList: CurrentDevices[];
  public phoneNumberList: PhoneNumber[];
  public addDevice: Devices; //device the user clicking on to add to their current devices
  public editDevice: Devices;
  public deleteDevice: Devices; //delete device when the user clicks delete
  open_error: boolean = false;
  
  

  public findTotalRows(data){    
    for(let j=0;j<data.length;j++){ 
      this.numDevices=j+1;  
    } 
  } 

  public getCurrentDevices(): void {
    this.CurrentDevicesService.getCurrentDevices().subscribe({
      next: (response: CurrentDevices[]) => {
        this.currentDevicesList = response;
        this.findTotalRows(this.currentDevicesList); 
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public getDevices(): void {
    this.DevicesService.getDevices().subscribe({
      next: (response: Devices[]) => {
        this.devicesList = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

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

      // use a Form to delete a plan to the backend
      public onDeleteCurrentDevice(currentDeviceId: number): void {
        document.getElementById("delete-plan-form").click();
        this.CurrentDevicesService.deleteCurrentDevices(currentDeviceId).subscribe({
          //void because service does not return anything
          next: (response: void) => { 
            this.getCurrentDevices(); //call getPlans to re-update list
          },
          error: (error: HttpErrorResponse) => {
            alert(error.message);
          }
        });
      }

    // use a Form to add a current device to the backend
    public onAddDevice(currentDevice: CurrentDevices): void {
      document.getElementById("add-plan-form").click();
      this.CurrentDevicesService.addCurrentDevices(currentDevice).subscribe({
        next: (response: CurrentDevices) => {
          this.getCurrentDevices(); //call getDevices to re-update list
        },
        error: (error: HttpErrorResponse) => {
          this.open_error = true; 
        }
      });
      this.open_error = false; 
    }

        // use a Form to add a current device to the backend
        public onEditDevice(currentDevice: CurrentDevices): void {
          document.getElementById("edit-plan-form").click();
          this.CurrentDevicesService.updateCurrentDevices(currentDevice).subscribe({
            next: (response: CurrentDevices) => {
              console.log(response)
              this.getCurrentDevices(); //call getDevices to re-update list
            },
            error: (error: HttpErrorResponse) => {
              this.open_error = true; 

            }
          });
          this.open_error = false; 
        }

    

      // use this to control which modal shows when a specific button is pressed
      public onOpenModal(device: Devices, mode: string): void {
        const container = document.getElementById("main-container");
        const button = document.createElement("button");
        button.type = "button";
        button.style.display = "none";
        button.setAttribute("data-backdrop","static");
        button.setAttribute("data-bs-toggle", "modal");
        
        //open the add modal if the user clicks the "add now" button
        if (mode === "add") {
          this.addDevice = device;
          button.setAttribute('data-bs-target', '#addModal');
          this.getPhoneNumbers();
        }
        if (mode === "edit") {
          this.editDevice = device;
          button.setAttribute('data-bs-target', '#editModal');
          this.getPhoneNumbers();          
        }
        // Open the Delete Modal if the user clicks the delete button
        if (mode === "delete") {
          this.deleteDevice = device;
          button.setAttribute("data-bs-target", "#deleteDevicesModal");
        }
        container.appendChild(button);
        button.click();
      }


  async ngOnInit() {
    this.getDevices();
    this.getCurrentDevices();
    this.getPhoneNumbers();

    this.deviceLimit = this.sharedService.getDeviceLimit();


  }

}


