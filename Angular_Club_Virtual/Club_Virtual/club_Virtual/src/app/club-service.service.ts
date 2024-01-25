import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ClubServiceService {
  
  //atributos
  public ListaEspecialidades: any[];
  public ListaCategorias: any [];
  public urlServidor: string = "http://localhost:8081/";
  public integrante: any;

  constructor(private postMan: HttpClient) {
    this.ListaEspecialidades = [];
    this.ListaCategorias = [];
    this.integrante = {};
   }


   obtenerListaEspecialidades(): void {
    this.postMan.get(this.urlServidor + "api/especialidades").subscribe((respuesta: any) => {
      console.log(respuesta);
      this.ListaEspecialidades = respuesta;
    });
   }

   obtenerListaCategorias(): void {
    this.postMan.get(this.urlServidor + "api/especialidades/categorias").subscribe((respuesta: any) => {
      console.log(respuesta);
      this.ListaCategorias = respuesta;
    });
   }



   eliminarEspecialidad(id: number): void {
    const parametroPeticion = new HttpParams()
    .set("id", id)
    this.postMan.delete(this.urlServidor + "api/especialidades/eliminar", {params: parametroPeticion}).subscribe(
      (respuesta: any) => {
        console.log(respuesta);
        this.obtenerListaEspecialidades();
      });
   }


   guardarEspecialidad( nombre: string, categoria: string, requisitos:string){
    this.postMan.post(this.urlServidor + "api/especialidades",{
      "nombre": nombre,
      "categoria":categoria,
      "requisitos":requisitos
    },).subscribe((respuesta: any) => {
      console.log(respuesta.msg);
    })

   }


}
