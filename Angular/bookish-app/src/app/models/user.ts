import { Book } from "./book";

export interface User {
    username : string,
    email : string,
    password : string,
    profileImage : string,
    readList : Book[],
    toReadList : Book[]
}