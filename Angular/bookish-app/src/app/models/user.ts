import { Book } from "./book";

export interface User {
    username : string,
    email : string,
    password : string,
    profileImage : string,
    userBooks: Book[],
    readList : Book[],
    toReadList : Book[]
}