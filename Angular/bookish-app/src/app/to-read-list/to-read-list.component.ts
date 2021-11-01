import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-to-read-list',
  templateUrl: './to-read-list.component.html',
  styleUrls: ['./to-read-list.component.css']
})
export class ToReadListComponent implements OnInit {

  currentUser!: User;
  bookList: Book[] = [];



  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
    this.bookList = this.currentUser.readList;
  }

}
