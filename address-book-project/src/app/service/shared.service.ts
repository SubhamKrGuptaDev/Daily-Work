import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';

@Injectable({
  providedIn: 'root', // This makes the service available globally
})
export class SharedService {
  public addressObject: Array<Address> = [
    {
      name: 'Subham',
      email: 'subham@gmail.com',
      mobileNo: '+91489887891',
      country: 'India',
      state: 'West Bengal',
      city: 'Kharagpur',
      description: 'Inda',
      pinCode: '721305',
    },
    {
      name: 'Rahul',
      email: 'rahul@gmail.com',
      mobileNo: '+76398742354',
      country: 'India',
      state: 'West Bengal',
      city: 'Kolkata',
      description: 'new town',
      pinCode: '700010',
    },
  ];
  public curSelect: Address = {
    name: '',
    email: '',
    mobileNo: '',
    country: '',
    state: '',
    city: '',
    description: '',
    pinCode: '',
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
      name: '',
      email: '',
      mobileNo: '',
      country: '',
      state: '',
      city: '',
      description: '',
      pinCode: '',
    };
  }
}
