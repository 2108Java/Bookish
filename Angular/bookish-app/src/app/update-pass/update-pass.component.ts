import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-update-pass',
  templateUrl: './update-pass.component.html',
  styleUrls: ['./update-pass.component.css']
})
export class UpdatePassComponent implements OnInit {

  currentUser!: User;
  message: string | undefined = "";

  constructor(private userService: UserService) { }

  changePassword(newPassword: string) {
    this.userService.changePassword(newPassword).subscribe(
      response => { 

        this.message = response.body?.message;
        
      }
    );
  }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
  }

}
