import { Rating } from "./rating";

export interface Book {
    apiId : string,
    title : string,
    author : string,
    description : string,
    image : string,
    dateFinished : number,
    rating : Rating,
    review : string
}