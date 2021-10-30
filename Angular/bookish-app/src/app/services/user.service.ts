import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user!: User;
  baseUrl: string = "http://localhost:8000/api";
  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
     
    withCredentials: true, 
    observe: 'response' as 'response'
    };  

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<HttpResponse<User>> {
    let addonUrl: string = "/login";
    let fullUrl: string = this.baseUrl + addonUrl;

    this.user.username = username;
    this.user.password = password;

    return this.http.post<User>(fullUrl, this.user, this.httpOptions); 

  }

  changePassword(password: string): void {
    let addonUrl: string = "/password";
    let oldPassword: string = "";

    oldPassword = this.user.password;
    this.user.password = password;

  }

  registerUser(username: string, email: string): Observable<HttpResponse<string>> {
    let addonUrl: string = "/register";
    let fullUrl: string = this.baseUrl + addonUrl;
    this.user.username = username;
    this.user.email = email;
    
    return this.http.post<string>(fullUrl, this.user, this.httpOptions);
  }

  logout(): Observable<string> {
    let addonUrl: string = "/logout";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<string>(fullUrl,{withCredentials: true});
  }

  updateList(): void {
    let addonUrl: string = "/list";
    let fullUrl: string = this.baseUrl + addonUrl;
  }
}
