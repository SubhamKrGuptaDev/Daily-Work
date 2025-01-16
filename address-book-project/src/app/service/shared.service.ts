import { Injectable } from '@angular/core';
import { Address } from '../interface/address.interface';
import { ApiServiceService } from './api-service.service';

@Injectable({
  providedIn: 'root', // This makes the service available globally
})
export class SharedService {
  public addressObject: Array<Address> = [];
  public isDataPresentInDetails: Boolean = false

  public operationMap = {
    UPDATE: 'UPDATE',
    CREATE: 'CREATE'
  }

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
  constructor(private api: ApiServiceService) {}

  setAddressArray(addressArr: Array<Address>) {
    this.addressObject = addressArr;
  }

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

  setAllAddress() {
    this.api.getAll().subscribe(
      (result) => {
        this.setAddressArray(result)
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get getAllAddress() {
    return this.addressObject;
  }

}
