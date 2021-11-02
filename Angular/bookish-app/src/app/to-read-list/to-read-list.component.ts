import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { Rating } from '../models/rating';
import { User } from '../models/user';
import { BookService } from '../services/book.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-to-read-list',
  templateUrl: './to-read-list.component.html',
  styleUrls: ['./to-read-list.component.css']
})
export class ToReadListComponent implements OnInit {

  currentUser!: User;
  bookList: Book[] = [];
  selectedLevel!: string;

  submitFinishedBook(event: any, review: string) {
    let book: Book = {apiId : "", title : "", author : "", description : "", image : "", dateFinished : 0, rating : Rating.ZERO, review : ""};
    book.apiId = event.target.id;
    let rating: Rating;
    switch(this.selectedLevel) {
      case "ZERO":
        rating = Rating.ZERO;
        break;
      case "ONE":
        rating = Rating.ONE;
        break;
      case "TWO":
        rating = Rating.TWO;
        break;
      case "THREE":
        rating = Rating.THREE;
        break;
      case "FOUR":
        rating = Rating.FOUR;
        break;
      case "FIVE":
        rating = Rating.FIVE;
        break;
      default:
        return;
    }
    this.bookService.getBookFromExternalAPIById(book.apiId).subscribe(
      data => { 

        book.author = data.volumeInfo.authors[0];
        book.title = data.volumeInfo.title;
        if(data.volumeInfo.subtitle != null) {
          book.title += ": " + data.volumeInfo.subtitle;
        }
        book.description = data.volumeInfo.description;
        if(data.volumeInfo.imageLinks != null){
          if(data.volumeInfo.imageLinks.thumbnail != null){
            book.image = data.volumeInfo.imageLinks.thumbnail;
          }
          else if(data.volumeInfo.imageLinks.smallThumbnail != null) {
            book.image = data.volumeInfo.imageLinks.smallThumbnail;
          }
        }
        this.currentUser = this.bookService.finishBook(this.currentUser, book, review, rating);
        this.userService.CurrentUser = this.currentUser;
      }
    );

  }

  constructor(private userService: UserService, private bookService: BookService) { }

  ngOnInit(): void {
    this.currentUser = this.userService.CurrentUser;
    this.bookList = this.currentUser.toReadList;
  }

}
