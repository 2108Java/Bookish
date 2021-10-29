import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../models/book';
import { Rating } from '../models/rating';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl: string = "https://www.googleapis.com/books/v1/volumes";

  constructor(private http: HttpClient) { }

  getBookFromExternalAPIById(id: number): Book {
    let book!: Book;
    let addonUrl: string = "/" + id;

    return book;

  }

  getBooksFromExternalAPIByAuthor(author: string): Book[] {
    let bookArray!: Book[];
    let addonUrl: string = "?q=inauthor:" + author + "&langRestrict=en&printType=books";

    return bookArray;
  }

  getBooksFromExternalAPIByTitle(title: string): Book[] {
    let bookArray!: Book[];
    let addonUrl: string = "?q=intitle:" + title + "&langRestrict=en&printType=books";

    return bookArray;
  }

  finishBook(user: User, book: Book, review: string, rating: Rating): User {
    book.review = review;
    book.rating = rating;
    book.dateFinished = Date.now();
    this.removeFromWantToReadList(user ,book);
    this.addToHaveReadList(user, book);

    return user;
  }

  splitList(user: User): User {
    user.readList = [];
    user.toReadList = [];

    for(let book of user.userBooks) {
      if(book.dateFinished != null) {
        user.readList.push(book);
      } else {
        user.toReadList.push(book);
      }
    }

    return user;
  }

  combineList(user: User): User {
    user.userBooks = user.readList.concat(user.toReadList);

    return user;
  }

  addToWantToReadList(user: User, book: Book): User {
    user.toReadList.push(book);

    return user;
  }

  removeFromWantToReadList(user: User, book: Book): User {
    let bookPosition: number = -1;

    for(let b of user.toReadList){
      if(b.id == book.id){

        bookPosition = user.toReadList.indexOf(b);

        user.toReadList.splice(bookPosition,1);

        // this.filteredPlanets = this.planets;
      }
    }

    return user;
  }

  addToHaveReadList(user: User, book: Book): User {
    user.readList.push(book);

    return user;
  }
  
}
