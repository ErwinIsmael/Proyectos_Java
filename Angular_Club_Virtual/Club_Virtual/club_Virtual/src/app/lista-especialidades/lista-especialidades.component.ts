import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { ClubServiceService } from '../club-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-lista-especialidades',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './lista-especialidades.component.html',
  styleUrl: './lista-especialidades.component.css'
})
export class ListaEspecialidadesComponent {

  @ViewChild("nombre")
  referenciaNombre!: ElementRef;

  @ViewChild("categoria")
  referenciaCategoria!: ElementRef;

  @ViewChild("requisitos")
  referenciaRequisitos!: ElementRef;



  constructor(public servicio: ClubServiceService, private router: Router ){
    this.servicio.obtenerListaEspecialidades();
    this.servicio.obtenerListaCategorias();
  }

  //get 
  get listaEspecialidades(){
    return this.servicio.ListaEspecialidades;
  }

  get listaCategorias(){
    return this.servicio.ListaCategorias;
  }


  guardarEspecialidad(){
    const nombre = this.referenciaNombre.nativeElement.value;
    const categoria = this.referenciaCategoria.nativeElement.value;
    const requisitos = this.referenciaRequisitos.nativeElement.value;
    this.servicio.guardarEspecialidad(nombre, categoria, requisitos);
    //this.router.navigate(["especialidades"])
    Swal.fire({
      position: "top-start",
      icon: "success",
      title: "Especialidad dada de alta correctamente!",
      showConfirmButton: false,
      timer: 10500
    });
  }

  eliminar(id: number){
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.servicio.eliminarEspecialidad(id);
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    });


  }







}
