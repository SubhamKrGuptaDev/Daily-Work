import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Address } from 'src/app/interface/address.interface';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { SharedService } from 'src/app/service/shared.service';
import { AddressListComponent } from '../address-list/address-list.component';
import { HomeComponent } from '../home-component/home-component.component';

@Component({
  selector: 'app-modal-container',
  templateUrl: './modal-container.component.html',
  styleUrls: ['./modal-container.component.css'],
})
export class ModalContainerComponent {
  @Input() modalRef: any;

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
    // this.addressForm = new FormGroup({
    //   name: new FormControl('', [Validators.required]),
    //   email: new FormControl('', [Validators.email]),
    //   mobileNo: new FormControl()
    // });
  }

  ngOnInit() {}

  create() {
    this.api.create(this.address).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
    this.modalRef.close();

  }
}
