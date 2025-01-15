import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteContainerComponent } from './delete-container.component';

describe('DeleteContainerComponent', () => {
  let component: DeleteContainerComponent;
  let fixture: ComponentFixture<DeleteContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteContainerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
