import { Injectable } from '@angular/core';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor() { }

  getBookFromExternalAPI(): Book {
    let book!: Book;

    return book;

  }

  searchForBooksByAuthor(): Book[] {
    let bookArray!: Book[];

    return bookArray;
  }

  createReview(): void {

  }

  rateBook(): void {

  }

  addToWantToReadList(): void {

  }

  removeFromWantToReadList(): void {

  }

  addToHaveReadList(): void {

  }

  removeFromHaveReadList(): void {

  }

  
}
