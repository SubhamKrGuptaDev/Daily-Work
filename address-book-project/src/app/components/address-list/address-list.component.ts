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

  constructor(private share: SharedService) {
    this.addressArray = share.addressObject;
  }

  viewAddress(address: Address) {
    this.setAddress(address);
  }

  setAddress(address: Address) {
    this.share.setCurAddress(address);
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
