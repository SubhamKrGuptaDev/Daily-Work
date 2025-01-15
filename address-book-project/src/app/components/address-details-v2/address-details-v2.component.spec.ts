import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddressDetailsV2Component } from './address-details-v2.component';

describe('AddressDetailsV2Component', () => {
  let component: AddressDetailsV2Component;
  let fixture: ComponentFixture<AddressDetailsV2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddressDetailsV2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddressDetailsV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
