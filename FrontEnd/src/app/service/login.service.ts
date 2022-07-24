import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Response/user';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServeUrl="http://localhost:8080/user/login";
  constructor(private httpClient: HttpClient) { }

  loginUser(user: User):Observable<object>{
    console.log(user)
    return this.httpClient.post(`${this.apiServeUrl}`, user);
  }
}
