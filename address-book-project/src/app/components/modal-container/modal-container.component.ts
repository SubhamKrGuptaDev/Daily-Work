import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-modal-container',
  templateUrl: './modal-container.component.html',
  styleUrls: ['./modal-container.component.css'],
})
export class ModalContainerComponent {
  @Input() address: Address = {
    id: 0,
    name: '',
    address: '',
    email: '',
    mobileNo: '',
    landline: '',
    website: '',
  };

  constructor(private share: SharedService) {}

  ngOnInit() {}
}
