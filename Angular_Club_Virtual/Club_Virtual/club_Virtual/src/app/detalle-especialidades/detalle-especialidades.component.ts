import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClubServiceService } from '../club-service.service';

@Component({
  selector: 'app-detalle-especialidades',
  standalone: true,
  imports: [],
  templateUrl: './detalle-especialidades.component.html',
  styleUrl: './detalle-especialidades.component.css'
})
export class DetalleEspecialidadesComponent {

  private params: any;
  private id: number = 0;



  constructor(private ruta: ActivatedRoute, private servicio:ClubServiceService){
    this.params = this.ruta.params.subscribe( parametros => {
      this.id = parametros["id"]
    })
  }

}
