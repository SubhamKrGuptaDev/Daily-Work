import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home-component/home-component.component';
import { AddressAddComponent } from './components/address-add/address-add.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'add',
    component: AddressAddComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
