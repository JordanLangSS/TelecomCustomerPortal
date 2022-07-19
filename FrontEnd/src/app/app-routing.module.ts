import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DevicesComponent } from './devices/devices.component';
import { PlansComponent } from './plans/plans.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [

  {
    path: 'user', component: UserComponent
  },
  {
    path: 'plans', component: PlansComponent
  },
  {
    path: 'devices', component: DevicesComponent
  },
  {
    path: 'sign-in', component: SignInComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
