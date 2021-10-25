import { Rating } from "./rating";

export interface Book {
    id : number,
    title : string,
    author : string,
    description : string,
    imageLink : string,
    dateFinished : Date,
    rating : Rating,
    review : string
}