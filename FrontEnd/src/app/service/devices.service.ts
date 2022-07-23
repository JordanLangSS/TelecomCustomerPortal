import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Devices } from '../Response/devices';

@Injectable({
  providedIn: 'root'
})
export class DevicesService {
  private apiServeUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getDevices(): Observable<Devices[]> {
    return this.http.get<Devices[]>(`${this.apiServeUrl}/device/all`);
  }

  public addDevices(devices: Devices): Observable<Devices> {
    return this.http.post<Devices>(`${this.apiServeUrl}/device/add`, devices);
  }

  public updateDevices(devices: Devices): Observable<Devices> {
    return this.http.put<Devices>(`${this.apiServeUrl}/device/update`, devices);
  }

  public deleteDevices(deviceId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServeUrl}/device/delete/${deviceId}`);
  }
}
