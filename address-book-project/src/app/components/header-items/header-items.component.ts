import { I18nPluralPipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddressAddComponent } from '../address-add/address-add.component';
import { ModalContainerComponent } from '../modal-container/modal-container.component';

@Component({
  selector: 'app-header-items',
  templateUrl: './header-items.component.html',
  styleUrls: ['./header-items.component.css'],
})
export class HeaderItemsComponent {
  @Input() title: String = '';
  @Input() link: String | undefined = '';

  constructor(private modal: NgbModal, private route: Router) {}

  open() {
    if (this.title === 'ADD+') {
      const modalRef = this.modal.open(ModalContainerComponent, {
        size: 'lg',
      });
    } else {
      this.route.navigate(['']);
    }
  }
}
