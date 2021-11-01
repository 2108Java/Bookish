import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-read-list',
  templateUrl: './read-list.component.html',
  styleUrls: ['./read-list.component.css']
})
export class ReadListComponent implements OnInit {

 // title : string | undefined;
 // subtitle : string | undefined;
 // author : string | undefined;
 // desc : string | undefined;
 currentUser!: User;
 bookList: Book[] = [];



  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
    this.bookList = this.currentUser.readList;
  }

}
