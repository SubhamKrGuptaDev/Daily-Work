import { ChangeDetectorRef, Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Address } from 'src/app/interface/address.interface';
import { SharedService } from 'src/app/service/shared.service';
import { ModalContainerComponent } from '../modal-container/modal-container.component';
import { DeleteContainerComponent } from '../delete-container/delete-container.component';
import { ActivatedRoute } from '@angular/router';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-address-details-v2',
  templateUrl: './address-details-v2.component.html',
  styleUrls: ['./address-details-v2.component.css'],
})
  export class AddressDetailsV2Component {
    address: Address | undefined;

    constructor(public sharedService: SharedService, 
      private modal: NgbModal, 
      private router: ActivatedRoute, 
      private apiService: ApiServiceService) {}

    ngOnInit() {
      this.router.paramMap.subscribe((paramMap) => {
        const addressid: string | null = paramMap.get("id") || '';
        if(this.isValidNumber(addressid)) {
          this.apiService.getById(parseInt(addressid, 10)).subscribe(
            (result) => {
              this.address = result
              console.log(this.address);
            },
            (error) => {
              console.log(error)
            }
          )

        }
      })
    }

    isValidNumber(id:String) {
      const num = Number(id);
      if(isNaN(num)) {
        return false;
      }
      return true;
    }

    editBtn() {
      if (this.isValidData()) {
        const modalRef = this.modal.open(ModalContainerComponent, {
          size: 'lg',
        });
        modalRef.componentInstance.modalRef = modalRef;
        modalRef.componentInstance.address = this.address;
        modalRef.componentInstance.operationType = this.sharedService.operationMap.UPDATE
      }
    }

    deleteBtn() {
      if (this.isValidData() && this.address) {
        const modalRef = this.modal.open(DeleteContainerComponent, {
          size: 'md',
        });
        modalRef.componentInstance.modalRef = modalRef;
        modalRef.componentInstance.id = this.address.id;
      }
    }

    isValidData() {
      return this.address && this.address.name && this.address.name.length > 0;
    }
  }
