import { Book } from "./book";

export interface User {
    username : string | undefined,
    email : string | undefined,
    password : string | undefined,
    profileImage : string | undefined,
    userBooks: Book[] | undefined,
    readList : Book[],
    toReadList : Book[]
}