import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Address } from 'src/app/interface/address.interface';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-modal-container',
  templateUrl: './modal-container.component.html',
  styleUrls: ['./modal-container.component.css'],
})
export class ModalContainerComponent {
  @Input() modalRef: any;
  @Input() operationType: string | undefined;

  // addressForm: FormGroup;

  @Input() address: Address = {
    id: 0,
    name: '',
    address: '',
    email: '',
    mobileNo: '',
    landline: '',
    website: '',
  };

  constructor(
    private share: SharedService,
    private api: ApiServiceService,
    private modal: NgbModal,
    private router: Router
  ) {
  }

  ngOnInit() {}

  create() {
    if(this.operationType) {
      if(this.operationType === this.share.operationMap.CREATE) {
        this.createApi();
      } else if(this.operationType === this.share.operationMap.UPDATE) {
        this.updateApi();
      }
    }
    this.modalRef.close();
  }

  updateApi() {
    this.api.update(this.address).subscribe(
      (response) => {
        this.share.setAllAddress()
      }, 
      (error) => {
        console.log(error)
      }
    )
  }

  createApi() {
    this.api.create(this.address).subscribe(
      (response) => {
        this.share.setAllAddress()
      },
      (error) => {
        console.log(error);
      }
    );
    this.modalRef.close();
  }

}
