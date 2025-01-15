import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';

@Injectable({
  providedIn: 'root', // This makes the service available globally
})
export class SharedService {
  public addressObject: Array<Address> = [
    {
      id: 1,
      name: 'Subham',
      email: 'subham@gmail.com',
      mobileNo: '+91489887891',
      address: 'Inda',
      landline: '+978634324',
      website: 'www.address.com',
    },
    {
      id: 2,
      name: 'Rahul',
      email: 'rahul@gmail.com',
      mobileNo: '+76398742354',
      address: 'new town',
      landline: '+978634324',
      website: 'www.address.com',
    },
  ];
  public curSelect: Address = {
    id: 0,
    name: '',
    email: '',
    mobileNo: '',
    address: '',
    landline: '',
    website: '',
  };
  public curIndex: Number | undefined;
  constructor() {}

  setCurAddress(address: Address, index: Number) {
    Object.assign(this.curSelect, address); // (target, source)
    this.curIndex = index;
  }

  addNewAddress(address: Address) {
    this.addressObject.push(address);
  }

  removeAddress() {
    if (this.curIndex !== undefined) {
      this.addressObject = this.addressObject.filter(
        (values, index) => index !== this.curIndex
      );
      this.curIndex = undefined;
      this.emptyCurObject();
    }
  }

  emptyCurObject() {
    this.curSelect = {
      id: 0,
      name: '',
      email: '',
      mobileNo: '',
      address: '',
      landline: '',
      website: '',
    };
  }
}
