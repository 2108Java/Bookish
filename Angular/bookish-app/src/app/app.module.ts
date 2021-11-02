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
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RegisterFormComponent } from './register-form/register-form.component';
import { UpdatePassComponent } from './update-pass/update-pass.component';
import { LogoutComponent } from './logout/logout.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LandPageComponent,
    ReadListComponent,
    ToReadListComponent,
    CurrentListComponent,
    ProfileMenuComponent,
    RegisterFormComponent,
    UpdatePassComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
