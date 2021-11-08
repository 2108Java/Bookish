# Bookish
Bookish repository for team Byte me

# Project Description
A reading tracking app designed to help readers keep track of the books they have previously read and to manage their to-be-read (TBR) list. New users can register for an account. Existing users can login, update their password, add/remove books from their lists, and provide a rating, review, and completion date for individual books.

# Technologies Used
* Java 8
* Spring Boot and Data - version 2.5.6
* Spring Web - version 2.5.6
* Lombok – version 4.11.1
* Junit – version 4.13.2
* Mockito – version 3.12.4
* Postgresql – version 42.2.23
* Angular – version 12.2.11
* Typescript – version 3.9.6
* Bootstrap – version 4.0

# Features
List of features ready and TODOs for future development

* New users can register an account.
* Existing users can login/logout.
* Existing users can update their password.
* The application encrypts stored passwords.
* Users can search for a book by title/author.
* The application retrieves search results from the Google Books API.
* Users can add/remove books from their read list.
* Users can add/remove books from their to-read list.
* Users can rate, review, and add a completion date to individual books.

To-do list:

* Users can upload a profile photo.
* Users can add a book that does not appear in search results.
* The application will suggest/recommend books to users.
* Users can set a reading challenge. How many books they want to read in the current year.
* User can view the ratings/reviews for a book from other users.

# Getting Started
git clone https://github.com/2108Java/Bookish.git  

To setup the database:  
In the DBMS of your choice create a database - If using PostgreSql run the script BookishDBSchema  
If not using PostgreSql the application.properties file and the pom.xml file in the Java application will need to be updated  

To run the Java application:  
Update the application.properties file - the username, password, and database endpoint should all be updated  
In BookishController.java the options for @CrossOrigin should be updated - to run locally remove the existing array and add http://localhost:4200  

To run the Angular SPA:  
Inside the application directory open the Angular CLI and run npm install  
Update the user.service.ts file - the baseUrl should be http://localhost:8000/api  

# Usage
To get started once the Java and Angular applications are running register a user.  
Once there is at least one registered user the dashboard can be used to search the Google Books API.  
The navigation bar provides links to other features such as the read list and to-read list.  
There are no alerts or toasts, so to confirm that a book has been added to a list click on the corresponding link in the navigation bar.  

# Contributors
Nate Buckley  
Lauren Pena  
Janet Joseph  
Yibeltal Zerihun

# License
This project does not use any licenses.
