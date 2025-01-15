import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';
import { ModalContainerComponent } from '../modal-container/modal-container.component';
import { DeleteContainerComponent } from '../delete-container/delete-container.component';

@Component({
  selector: 'app-address-details-v2',
  templateUrl: './address-details-v2.component.html',
  styleUrls: ['./address-details-v2.component.css'],
})
export class AddressDetailsV2Component {
  address: Address;

  constructor(public sharedService: SharedService, private modal: NgbModal) {
    this.address = sharedService.curSelect;
    console.log(this.sharedService.curIndex);
  }

  ngOnInit() {
  }

  editBtn() {
    if (this.isValidData()) {
      const modalRef = this.modal.open(ModalContainerComponent, {
        size: 'lg',
      });
      modalRef.componentInstance.modalRef = modalRef;
      modalRef.componentInstance.address = this.address;
    }
  }

  deleteBtn() {
    if (this.isValidData()) {
      const modalRef = this.modal.open(DeleteContainerComponent, {
        size: 'md',
      });
      modalRef.componentInstance.modalRef = modalRef;
      modalRef.componentInstance.id = this.address.id;
    }
  }

  isValidData() {
    return this.address.name.length > 0;
  }
}
