import { Component } from '@angular/core';
import { ClientesServiceService } from '../clientes-service.service';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {

  /**
   *
   */
  constructor(public servicio: ClientesServiceService) {
    this.servicio.obtenerListaClientes();
    
    
  }

}
