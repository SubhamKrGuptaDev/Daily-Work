import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddressListComponent } from './components/address-list/address-list.component';
import { AddressDetailsComponent } from './components/address-details/address-details.component';
import { AddressAddComponent } from './components/address-add/address-add.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { HeaderComponent } from './header/header.component';
import { HeaderItemsComponent } from './header-items/header-items.component';

@NgModule({
  declarations: [
    AppComponent,
    AddressListComponent,
    AddressDetailsComponent,
    AddressAddComponent,
    HomeComponentComponent,
    HeaderComponent,
    HeaderItemsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}