import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule } from '@angular/forms';
import { User } from '../models/user';
import { BookService } from '../services/book.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-land-page',
  templateUrl: './land-page.component.html',
  styleUrls: ['./land-page.component.css']
})
export class LandPageComponent implements OnInit {

  currentUser!: User;

  form = new FormGroup({
    gender: new FormControl('')
  });

  constructor(private bookService: BookService, private userService: UserService) {
    this.currentUser = {username: "", password: "", email: "", profileImage:"", userBooks: [], readList: [], toReadList: []};
    this.currentUser = this.userService.CurrentUser;

    if(this.currentUser.userBooks != null) {
      for(let book of this.currentUser.userBooks) {
        this.bookService.getBookFromExternalAPIById(book.apiId).subscribe(
          data => { 

            book.author = data.volumeInfo.authors[0];
            book.title = data.volumeInfo.title;
            if(data.volumeInfo.subtitle != null) {
              book.title += ": " + data.volumeInfo.subtitle;
            }
            book.description = data.volumeInfo.description;
            book.image = data.volumeInfo.imageLinks.thumbnail;
            
          }
        );
      }
    }
   }

   submitSearch(searchTerm: string, choice: string) {
    
   }

  ngOnInit(): void {
      this.currentUser = this.bookService.splitList(this.currentUser);
    
  }

}
