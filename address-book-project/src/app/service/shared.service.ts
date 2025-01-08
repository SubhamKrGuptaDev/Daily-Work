import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';

@Injectable({
  providedIn: 'root', // This makes the service available globally
})
export class SharedService {
  public addressObject: Array<Address>;
  public curSelect: Address;
  constructor() {
    // Dummy Object
    this.addressObject = [
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
    ];
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
