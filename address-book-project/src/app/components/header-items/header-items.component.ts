import { I18nPluralPipe } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header-items',
  templateUrl: './header-items.component.html',
  styleUrls: ['./header-items.component.css'],
})
export class HeaderItemsComponent {
  @Input() title: String = '';
  @Input() link: String | undefined = '';
}
