import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddressDetailsV2Component } from './components/address-details-v2/address-details-v2.component';

const routes: Routes = [
  {path:':id', component: AddressDetailsV2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
