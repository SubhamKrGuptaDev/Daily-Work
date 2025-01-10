import { Component } from '@angular/core';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'address-list-app',
  templateUrl: './address-list.component.html',
  styleUrls: ['./address-list.component.css'],
})
export class AddressListComponent {
  addressArray: Array<Address>;

  constructor(private shareService: SharedService) {
    this.addressArray = shareService.addressObject;
  }

  ngOnInit() {}

  viewAddress(address: Address, index: Number) {
    this.setAddress(address, index);
  }

  setArrayAddress(newAddress: Array<Address>) {
    this.addressArray = newAddress;
  }

  setAddress(address: Address, index: Number) {
    this.shareService.setCurAddress(address, index);
    // this.share.curSelect.name = address.name;
    // this.share.curSelect.email = address.email;
    // this.share.curSelect.mobileNo = address.mobileNo;
    // this.share.curSelect.city = address.city;
    // this.share.curSelect.country = address.country;
    // this.share.curSelect.description = address.description;
    // this.share.curSelect.pinCode = address.pinCode;
    // this.share.curSelect.state = address.state;
  }
}
