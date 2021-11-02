import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToReadListComponent } from './to-read-list.component';

describe('ToReadListComponent', () => {
  let component: ToReadListComponent;
  let fixture: ComponentFixture<ToReadListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToReadListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ToReadListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
