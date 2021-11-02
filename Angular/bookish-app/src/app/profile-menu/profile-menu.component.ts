import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profile-menu',
  templateUrl: './profile-menu.component.html',
  styleUrls: ['./profile-menu.component.css']
})
export class ProfileMenuComponent implements OnInit {

  currentUser!: User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
  }

}
