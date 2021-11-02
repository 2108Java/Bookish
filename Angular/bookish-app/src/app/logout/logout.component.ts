import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { BookService } from '../services/book.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  currentUser!: User;

  constructor(private userService: UserService, private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
    this.currentUser = this.bookService.combineList(this.currentUser);
    this.userService.CurrentUser = this.currentUser;
    this.userService.updateList();
    this.userService.logout();
    this.router.navigate(['']);
  }

}
