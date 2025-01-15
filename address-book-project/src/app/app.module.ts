import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddressListComponent } from './components/address-list/address-list.component';
import { AddressDetailsComponent } from './components/address-details/address-details.component';
import { AddressAddComponent } from './components/address-add/address-add.component';
import { HomeComponent } from './components/home-component/home-component.component';
import { HeaderComponent } from './components/header/header.component';
import { HeaderItemsComponent } from './components/header-items/header-items.component';
import { AddressListItemComponent } from './components/address-list-item/address-list-item.component';
import { LogoComponent } from './components/logo/logo.component';
import { FormsModule } from '@angular/forms';
import { AddressDetailsV2Component } from './components/address-details-v2/address-details-v2.component';

@NgModule({
  declarations: [
    AppComponent,
    AddressListComponent,
    AddressDetailsComponent,
    AddressAddComponent,
    HomeComponent,
    HeaderComponent,
    HeaderItemsComponent,
    AddressListItemComponent,
    LogoComponent,
    AddressDetailsV2Component,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
