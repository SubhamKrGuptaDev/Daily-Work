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
    name: '',
    city: '',
    country: '',
    description: '',
    email: '',
    mobileNo: '',
    pinCode: '',
    state: '',
  };

  constructor(private share: SharedService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe((param) => {
      console.log(param);
      this.address = {
        name: param['name'],
        city: param['city'],
        country: param['country'],
        description: param['description'],
        email: param['email'],
        mobileNo: param['mobileNo'],
        pinCode: param['pincode'],
        state: param['state'],
      };
    });
  }
}
