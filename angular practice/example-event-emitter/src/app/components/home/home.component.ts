import { Component } from '@angular/core';

let userListObj = [
  {
    id: 1,
    name: 'subham',
  },
  {
    id: 2,
    name: 'rahul',
  },
  {
    id: 3,
    name: 'rohit',
  },
  {
    id: 4,
    name: 'banty',
  },
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  userList = userListObj;
  selectId: number = 0;

  get selectedUser() {
    return userListObj.find((user) => user.id === this.selectId);
  }

  onSelectUser(userObj: any) {
    this.selectId = userObj.id;
  }
}
