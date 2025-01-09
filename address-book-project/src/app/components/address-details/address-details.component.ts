import { Component } from '@angular/core';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'address-details-app',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css'],
})
export class AddressDetailsComponent {
  address: Address;

  constructor(private sharedService: SharedService) {
    this.address = sharedService.curSelect;
  }
}
