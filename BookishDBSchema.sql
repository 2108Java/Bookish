--I googled most of the standard/maximum lengths for these fields
--They can be updated later if necessary

--store user information
create table users(
username varchar(15) primary key,
email varchar(320) unique not null,
password text not null
);

--store user specific information about books
create table user_books(
book_id serial,
api_id text not null,
username varchar(15) references users(username) not null,
review text,
rating ratings,
date_finished timestamp
);

