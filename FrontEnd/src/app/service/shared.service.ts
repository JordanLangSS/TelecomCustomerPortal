import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  constructor() {}

  deviceLimit: number;
  userId: any;

  setDeviceLimit(data) {
    this.deviceLimit = data;
  }

  getDeviceLimit() {
    return this.deviceLimit;
  }

  setUserId(data) {
    this.userId = data;
  }

  getUserId() {
    return this.userId;
  }
}
