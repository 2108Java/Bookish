import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser!: User;
  baseUrl: string = "http://localhost:8000/api";
  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
     
    withCredentials: true, 
    observe: 'response' as 'response'
    };  

  constructor(private http: HttpClient) {
    this.currentUser = {username: "", password: "", email: "", profileImage:"", userBooks: [], readList: [], toReadList: []};
   }

   get CurrentUser(){
    return this.currentUser;
  }

  set CurrentUser(newUser: User){
    this.currentUser = newUser;
  }

  login(username: string, password: string): Observable<HttpResponse<User>> {

    let addonUrl: string = "/login";
    let fullUrl: string = this.baseUrl + addonUrl;

    this.currentUser.username = username;
    this.currentUser.password = password;

    return this.http.post<User>(fullUrl, this.currentUser, this.httpOptions); 

  }

  changePassword(password: string): void {
    let addonUrl: string = "/password";
    let oldPassword: string | undefined = "";

    oldPassword = this.currentUser.password;
    this.currentUser.password = password;

  }

  registerUser(username: string, email: string): Observable<HttpResponse<string>> {
    let addonUrl: string = "/register";
    let fullUrl: string = this.baseUrl + addonUrl;
    this.currentUser.username = username;
    this.currentUser.email = email;
    
    return this.http.post<string>(fullUrl, this.currentUser, this.httpOptions);
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

  checkSession(): boolean {
    let addonUrl: string = "/session";
    let fullUrl: string = this.baseUrl + addonUrl;
    return true;
  }
}
