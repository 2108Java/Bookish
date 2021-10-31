import { Rating } from "./rating";

export interface Book {
    apiId : number,
    title : string,
    author : string,
    description : string,
    image : string,
    dateFinished : number,
    rating : Rating,
    review : string
}