import { Component } from '@angular/core';
import { Address } from 'src/app/interface/address.interface';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'address-list-app',
  templateUrl: './address-list.component.html',
  styleUrls: ['./address-list.component.css'],
})
export class AddressListComponent {

  constructor(
    public shareService: SharedService,
    private api: ApiServiceService
  ) {
    // this.addressArray = shareService.addressObject;
  }

  ngOnInit() {
    // try {
    //   this.addressArray = await firstValueFrom(this.api.getAll());
    // } catch (error) {
    //   console.error(error);
    // }
    this.api.getAll().subscribe(
      (result) => {
        this.shareService.setAddressArray(result)
      },
      (error) => {
        console.log(error);
      }
    );
  }

  viewAddress(address: Address, index: Number) {
    this.setAddress(address, index);
  }

  setAddress(address: Address, index: Number) {
    this.shareService.setCurAddress(address, index);
    this.shareService.isDataPresentInDetails = true
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
