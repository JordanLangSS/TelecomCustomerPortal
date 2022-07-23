import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  constructor() { }

  deviceLimit: number;
  
  setDeviceLimit(data) {
    this.deviceLimit = data;
  }

  getDeviceLimit() {
    return this.deviceLimit;
  }
}
