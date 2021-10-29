import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookService } from './services/book.service';
import { UserService } from './services/user.service';
import { HomePageComponent } from './home-page/home-page.component';
import { LandPageComponent } from './land-page/land-page.component';
import { ReadListComponent } from './read-list/read-list.component';
import { ToReadListComponent } from './to-read-list/to-read-list.component';
import { CurrentListComponent } from './current-list/current-list.component';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LandPageComponent,
    ReadListComponent,
    ToReadListComponent,
    CurrentListComponent,
    ProfileMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [BookService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
