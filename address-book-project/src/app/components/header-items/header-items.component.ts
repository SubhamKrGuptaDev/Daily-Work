import { I18nPluralPipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalContainerComponent } from '../modal-container/modal-container.component';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-header-items',
  templateUrl: './header-items.component.html',
  styleUrls: ['./header-items.component.css'],
})
export class HeaderItemsComponent {
  @Input() title: String = '';
  @Input() link: String | undefined = '';

  constructor(private modal: NgbModal, private route: Router, private share: SharedService) {}

  open() {
    if (this.title === 'ADD+') {
      const modalRef = this.modal.open(ModalContainerComponent, {
        size: 'lg',
      });
      modalRef.componentInstance.modalRef = modalRef;
      modalRef.componentInstance.operationType = this.share.operationMap.CREATE
    } else {
      this.route.navigate(['']);
    }
  }
}
