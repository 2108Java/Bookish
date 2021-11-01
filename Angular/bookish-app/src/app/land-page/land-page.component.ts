import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule } from '@angular/forms';
import { Book } from '../models/book';
import { Rating } from '../models/rating';
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
  searchList: Book[] = [];

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

   submitSearchByAuthor(searchTerm: string) {
    
    this.bookService.getBooksFromExternalAPIByAuthor(searchTerm).subscribe(
      data => { 

        for(let i of data.items) {
          let book: Book = {apiId : "", title : "", author : "", description : "", image : "", dateFinished : 0, rating : Rating.ZERO, review : ""};
          book.apiId = i.id;
          book.author = i.volumeInfo.authors[0];
          book.title = i.volumeInfo.title;
          if(i.volumeInfo.subtitle != null) {
            book.title += ": " + i.volumeInfo.subtitle;
          }
          book.description = i.volumeInfo.description;
          book.image = i.volumeInfo.imageLinks.thumbnail;

          this.searchList.push(book);
        }
      }
    );
   }

   submitSearchByTitle(searchTerm: string) {
    this.bookService.getBooksFromExternalAPIByTitle(searchTerm).subscribe(
      data => { 

        for(let i of data.items) {
          let book: Book = {apiId : "", title : "", author : "", description : "", image : "", dateFinished : 0, rating : Rating.ZERO, review : ""};
          book.apiId = i.id;
          book.author = i.volumeInfo.authors[0];
          book.title = i.volumeInfo.title;
          if(i.volumeInfo.subtitle != null) {
            book.title += ": " + i.volumeInfo.subtitle;
          }
          book.description = i.volumeInfo.description;
          book.image = i.volumeInfo.imageLinks.thumbnail;

          this.searchList.push(book);
        }
      }
    );
  }

  saveBook(event: any) {
    let book: Book = {apiId : "", title : "", author : "", description : "", image : "", dateFinished : 0, rating : Rating.ZERO, review : ""};
    book.apiId = event.target.id;
    this.bookService.getBookFromExternalAPIById(book.apiId).subscribe(
      data => { 

        book.author = data.volumeInfo.authors[0];
        book.title = data.volumeInfo.title;
        if(data.volumeInfo.subtitle != null) {
          book.title += ": " + data.volumeInfo.subtitle;
        }
        book.description = data.volumeInfo.description;
        book.image = data.volumeInfo.imageLinks.thumbnail;
        this.currentUser.toReadList.push(book);
      }
    );
  }

  ngOnInit(): void {
      this.currentUser = this.bookService.splitList(this.currentUser);
    
  }

}
