import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-current-list',
  templateUrl: './current-list.component.html',
  styleUrls: ['./current-list.component.css']
})
export class CurrentListComponent implements OnInit {

  currentUser!: User;
  bookList: Book[] = [];



  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
    this.bookList = this.currentUser.readList;
  }

}
