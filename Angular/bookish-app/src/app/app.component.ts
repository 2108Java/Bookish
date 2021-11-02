import { Component } from '@angular/core';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookish-app';
  isLoggedIn: boolean = false;
  isTryingToLogIn: boolean = true;

  logIn(): void {
    this.isLoggedIn = true;
  }

  loginOrRegister(switchingLogin: boolean): void {
    this.isTryingToLogIn = switchingLogin;
  }

  constructor() { }
}
