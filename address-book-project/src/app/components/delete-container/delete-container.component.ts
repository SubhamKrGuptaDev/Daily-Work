import { Component } from '@angular/core';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { SharedService } from 'src/app/service/shared.service';

@Component({
  selector: 'app-delete-container',
  templateUrl: './delete-container.component.html',
  styleUrls: ['./delete-container.component.css'],
})
export class DeleteContainerComponent {
  modalRef: any;
  id: Number = 0;

  constructor(private api: ApiServiceService, private share: SharedService) {}

  deleteData() {
    this.api.delete(this.id).subscribe(
      (result) => {
        console.log('Result : ', result);
        this.share.isDataPresentInDetails = false;
      },
      (error) => {
        console.log('Error : ', error);
      }
    );
    this.close();
  }

  close() {
    this.modalRef.close();
  }
}
