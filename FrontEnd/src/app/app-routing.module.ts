import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DevicesComponent } from './devices/devices.component';
import { PlansComponent } from './plans/plans.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { BillingComponent } from './billing/billing.component';
import { PhoneNumbersComponent } from './phone-numbers/phone-numbers.component';
import { HomeComponent } from './home/home.component';

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
    path: 'login', component: LoginComponent
  },
  {
    path: 'billing', component: BillingComponent
  },
  {
    path: 'phonenumber', component: PhoneNumbersComponent
  },
  {
    path: 'devices', component: DevicesComponent
  },
  {
    path: '', component: HomeComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
