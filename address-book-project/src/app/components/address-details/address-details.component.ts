import { Component } from '@angular/core';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';
import { AddressListComponent } from '../address-list/address-list.component';

@Component({
  selector: 'address-details-app',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css'],
})
export class AddressDetailsComponent {
  address: Address;

  constructor(private sharedService: SharedService) {
    this.address = sharedService.curSelect;
    // console.log(this.sharedService.addressObject);
    console.log(this.sharedService.curIndex);
  }

  editElement() {}

  deleteElement() {
    // console.log(this.sharedService.curIndex);
    this.sharedService.removeAddress();
    this.address = this.sharedService.curSelect;
  }
}
