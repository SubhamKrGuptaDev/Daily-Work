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
  }

  ngOnInit() {
    this.shareService.setAllAddress()
    
  }
}
