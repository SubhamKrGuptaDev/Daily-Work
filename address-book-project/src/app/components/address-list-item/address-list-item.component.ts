import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/interface/address.interface';

@Component({
  selector: 'app-address-list-item',
  templateUrl: './address-list-item.component.html',
  styleUrls: ['./address-list-item.component.css'],
})
export class AddressListItemComponent {
  @Input() address: Address | undefined;
  @Input() index: Number | undefined;

  @Input() isSelected!: boolean 

  constructor(private router: Router) {}

  routeAddress() {
    if(this.address?.id) {
      this.router.navigate(['',this.address.id]);
      this.isSelected = !this.isSelected
    }
  }

  checkSelect() {
    return this.isSelected
  }

}
