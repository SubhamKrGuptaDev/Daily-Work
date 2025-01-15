import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-address-add',
  templateUrl: './address-add.component.html',
  styleUrls: ['./address-add.component.css'],
})
export class AddressAddComponent {
  @Input() address: Address = {
    id: 0,
    name: '',
    address: '',
    email: '',
    mobileNo: '',
    landline: '',
    website: '',
  };

  constructor(private share: SharedService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe((param) => {
      console.log(param);
      this.address = {
        id: param['id'],
        name: param['name'],
        address: param['address'],
        email: param['email'],
        mobileNo: param['mobileNo'],
        landline: param['landline'],
        website: param['website'],
      };
    });
  }
}
