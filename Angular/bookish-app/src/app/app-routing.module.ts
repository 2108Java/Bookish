import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomePageComponent } from './home-page/home-page.component';
import { ReadListComponent } from './read-list/read-list.component';
import { ToReadListComponent } from './to-read-list/to-read-list.component';
import { CurrentListComponent } from './current-list/current-list.component';
import { UpdatePassComponent } from './update-pass/update-pass.component';
import { LogoutComponent } from './logout/logout.component';
import { LandPageComponent } from './land-page/land-page.component';
import { RegisterFormComponent } from './register-form/register-form.component';



import { SessionGuard } from './session.guard';

const routes: Routes = [
{ path: '', component: HomePageComponent },
{ path: 'register', component: RegisterFormComponent },
{ path: 'land-page', component: LandPageComponent, canActivate: [SessionGuard] },
{ path: 'read-list', component: ReadListComponent, canActivate: [SessionGuard] },
{ path: 'to-read-list', component: ToReadListComponent, canActivate: [SessionGuard] },
{ path: 'current-list', component: CurrentListComponent, canActivate: [SessionGuard] },
{ path: 'update-pass', component: UpdatePassComponent, canActivate: [SessionGuard] },
{ path: 'logout', component: LogoutComponent }];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
