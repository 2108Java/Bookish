import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookService } from './services/book.service';
import { UserService } from './services/user.service';
import { HomePageComponent } from './home-page/home-page.component';
import { LandPageComponent } from './land-page/land-page.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LandPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BookService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
