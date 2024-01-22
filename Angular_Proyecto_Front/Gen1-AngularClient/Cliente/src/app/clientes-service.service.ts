import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientesServiceService {

  //atributos
  public listaClientes: any[];
  public urlServidor: string = "http://localhost:8081/";
  public cliente: any;

  constructor(private postMan: HttpClient) { 
    this.listaClientes = [];
    this.cliente = {};
  }



  //metodos
  //metodos que realiuza una peticion get a la api // consume a tu api
  //para obtener la lista de clientes

  obtenerListaClientes(): void{
    this.postMan.get(this.urlServidor + "api/clientes").subscribe((respuesta: any) => {
      console.log(respuesta);
      this.listaClientes = respuesta;
    });
  }
}
