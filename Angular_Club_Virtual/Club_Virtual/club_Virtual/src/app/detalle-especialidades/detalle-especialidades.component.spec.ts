import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleEspecialidadesComponent } from './detalle-especialidades.component';

describe('DetalleEspecialidadesComponent', () => {
  let component: DetalleEspecialidadesComponent;
  let fixture: ComponentFixture<DetalleEspecialidadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleEspecialidadesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalleEspecialidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
