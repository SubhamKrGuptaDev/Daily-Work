import { Component } from '@angular/core';
import { HeaderItem } from 'src/app/interface/header-item.interface';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  header_items: Array<HeaderItem> = [
    { title: 'Home' },
    {
      title: 'Add +',
      link: 'add',
    },
  ];
  test: string = 'test';
}
