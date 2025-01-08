import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';

@Injectable({
  providedIn: 'root', // This makes the service available globally
})
export class SharedService {
  public addressObject: Array<Address>;
  constructor() {
    // Dummy Object
    this.addressObject = [
      {
        country: 'India',
        state: 'West Bengal',
        city: 'Kharagpur',
        description: 'Inda',
        pinCode: '721305',
      },
    ];
  }
}
