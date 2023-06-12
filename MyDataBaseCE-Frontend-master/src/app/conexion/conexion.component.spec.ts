import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConexionComponent } from './conexion.component';

describe('ConexionComponent', () => {
  let component: ConexionComponent;
  let fixture: ComponentFixture<ConexionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConexionComponent]
    });
    fixture = TestBed.createComponent(ConexionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
