import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css'],
})
export class UserItemComponent {
  @Input() id!: number;
  @Input() name!: string;

  @Output() userObj = new EventEmitter();

  onSelectUser() {
    this.userObj.emit({
      id: this.id,
      name: this.name,
    });
  }
}
