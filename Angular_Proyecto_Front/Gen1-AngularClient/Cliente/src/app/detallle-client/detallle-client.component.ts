import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientesServiceService } from '../clientes-service.service';

@Component({
  selector: 'app-detallle-client',
  standalone: true,
  imports: [],
  templateUrl: './detallle-client.component.html',
  styleUrl: './detallle-client.component.css'
})
export class DetallleClientComponent {

  //atributos
  private params: any;
  private id: number = 0;



  /**
   *
   */
  constructor(private ruta: ActivatedRoute, private servicio:ClientesServiceService) {

    this.params = this.ruta.params.subscribe( parametros => {
      this.id = parametros["id"];
      console.log(this.id);
      this.servicio.obtenerCliente(this.id);
    })
  }

  get cliente(){
    return this.servicio.cliente;
  }

}
