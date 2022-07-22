import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Devices } from '../Response/devices';
import { DevicesService } from '../service/devices.service';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})
export class DevicesComponent implements OnInit {
  
  
  public devicesList: Devices[];
  public deleteDevices: Devices;


  constructor(private DevicesService: DevicesService) {}

  public getDevices(): void {
    this.DevicesService.getDevices().subscribe({
      next: (response: Devices[]) => {
        this.devicesList = response;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    });
  }


  async ngOnInit() {
    this.getDevices();
  }

}
