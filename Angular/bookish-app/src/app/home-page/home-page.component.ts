import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
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

  @Output()onLogIn = new EventEmitter<boolean>();

  registerUser(username: string, email: string): void {
    this.userService.registerUser(username, email).subscribe(
      response => { 

        console.log(response);
        
      }
    );
  }

  login(username: string, password: string): void {
    this.userService.login(username, password).subscribe(
      response => { 

        this.user.username = response.body?.username;
        this.user.password = response.body?.password;
        this.user.email = response.body?.email;
        this.user.userBooks = response.body?.userBooks;

        this.userService.CurrentUser = this.user;

        this.onLogIn.emit(true);

        this.router.navigate(['/dashboard']);
        
      }
    );
  }

  constructor(private bookService: BookService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = {username: "", password: "", email: "", profileImage:"", userBooks: [], readList: [], toReadList: []};
  }

}
