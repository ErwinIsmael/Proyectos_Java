package com.jimenez.app.jpa.models;

import com.jimenez.app.jpa.enums.Categorias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "bc_especialidades")
@Entity
public class Especialidades {
	
	//atributos -> ariables -> caracteristicas
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ3")
	@SequenceGenerator(sequenceName = "clubvirtual_seq3", allocationSize = 1, name = "BC_SEQ3")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "categoria")
	private Categorias categoria;
	
	//2
	@Column(name = "requisitos")
	private String requisitos;
	
	//setter and getter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	


}
