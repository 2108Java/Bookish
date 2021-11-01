import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ReadListComponent } from './read-list/read-list.component';
import { ToReadListComponent } from './to-read-list/to-read-list.component';
import { CurrentListComponent } from './current-list/current-list.component';
import { UpdatePassComponent } from './update-pass/update-pass.component';
import { LogoutComponent } from './logout/logout.component';
import { LandPageComponent } from './land-page/land-page.component';
import { RegisterFormComponent } from './register-form/register-form.component';

import { SessionGuard } from './session.guard';

const routes: Routes = [
{ path: 'register', component: RegisterFormComponent },
{ path: 'land-page', component: LandPageComponent },
{ path: 'read-list', component: ReadListComponent },
{ path: 'to-read-list', component: ToReadListComponent },
{ path: 'current-list', component: CurrentListComponent },
{ path: 'update-pass', component: UpdatePassComponent },
{ path: 'logout', component: LogoutComponent },
{ path: 'dashboard', component: LandPageComponent, canActivate: [SessionGuard] }];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
