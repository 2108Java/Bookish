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

  logIn(): void {
    this.isLoggedIn = true;
  }

  constructor() { }
}
