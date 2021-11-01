import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  message: string | undefined = "";

  @Output() onSwitchToLogin = new EventEmitter();

  registerUser(username: string, email: string, password: string): void {
    this.userService.registerUser(username, email, password).subscribe(
      response => { 

        this.message= response.body?.message;
        
      }
    );
  }

  switchToLogin(): void {
    this.onSwitchToLogin.emit(true);
  }

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
