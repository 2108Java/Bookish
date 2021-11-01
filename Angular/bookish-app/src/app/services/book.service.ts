import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';
import { Rating } from '../models/rating';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl: string = "https://www.googleapis.com/books/v1/volumes";

  constructor(private http: HttpClient) { }

  getBookFromExternalAPIById(id: string): Observable<any> {
    let addonUrl: string = "/" + id;
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<any>(fullUrl);

  }

  getBooksFromExternalAPIByAuthor(author: string): Observable<any> {
    let addonUrl: string = "?q=inauthor:" + author + "&langRestrict=en";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<any[]>(fullUrl);
  }

  getBooksFromExternalAPIByTitle(title: string): Observable<any> {
    let addonUrl: string = "?q=intitle:" + title + "&langRestrict=en";
    let fullUrl: string = this.baseUrl + addonUrl;

    return this.http.get<any[]>(fullUrl);
  }

  finishBook(user: User, book: Book, review: string, rating: Rating): User {
    book.review = review;
    book.rating = rating;
    book.dateFinished = Date.now();
    user = this.removeFromWantToReadList(user ,book);
    user = this.addToHaveReadList(user, book);

    return user;
  }

  splitList(user: User): User {
    user.readList = [];
    user.toReadList = [];

    if(user.userBooks != undefined) {
      for(let book of user.userBooks) {
        if(book.dateFinished != null) {
          user.readList.push(book);
        } else {
          user.toReadList.push(book);
        }
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
      if(b.apiId == book.apiId){

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
