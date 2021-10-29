import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { BookService } from '../services/book.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  user!: User;

  registerUser(username: string, email: string) {
    this.userService.registerUser(username, email).subscribe(
      response => { 

        console.log(response);
        
      }
    );
  }

  login(username: string, password: string) {
    this.userService.login(username, password).subscribe(
      response => { 

        console.log(response);
        
      }
    );
  }

  constructor(private bookService: BookService, private userService: UserService) { }

  ngOnInit(): void {
  }

}
