import { Rating } from "./rating";

export interface Book {
    id : number,
    title : string,
    author : string,
    description : string,
    imageLink : string,
    dateFinished : number,
    rating : Rating,
    review : string
}