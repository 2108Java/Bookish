import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser!: User;
  registeredUser = {username: "", email: "", password: ""};
  // baseUrl: string = "http://localhost:8000/api";
  baseUrl: string = "http://ec2-18-217-229-161.us-east-2.compute.amazonaws.com:8000/api";
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

  changePassword(newPassword: string): Observable<HttpResponse<Message>> {
    let addonUrl: string = "/password";
    let oldPassword: string | undefined = "";
    let fullUrl: string = this.baseUrl + addonUrl;

    oldPassword = this.currentUser.password;
    this.currentUser.password = newPassword;

    return this.http.put<Message>(fullUrl, this.currentUser, this.httpOptions);
  }

  registerUser(username: string, email: string, password: string): Observable<HttpResponse<Message>> {
    let addonUrl: string = "/register";
    let fullUrl: string = this.baseUrl + addonUrl;
    this.registeredUser.username = username;
    this.registeredUser.password = password;
    this.registeredUser.email = email;
    
    return this.http.post<Message>(fullUrl, this.registeredUser, this.httpOptions);
  }

  logout(): Observable<Message> {
    let addonUrl: string = "/logout";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<Message>(fullUrl,{withCredentials: true});
  }

  updateList(): Observable<HttpResponse<Message>> {
    let addonUrl: string = "/list";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.put<Message>(fullUrl, this.currentUser, this.httpOptions);
  }

  checkSession(): Observable<boolean> {
    let addonUrl: string = "/session";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<boolean>(fullUrl,{withCredentials: true});
  }
}
