package com.jimenez.app.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "bc_clases")
@Entity
public class Clase {
	//atributos
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ5")
	@SequenceGenerator(sequenceName = "clubvirtual_seq5", allocationSize = 1, name = "BC_SEQ5")
	private Long id;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "requisitos")
	private String requisitos;
	
	//2
	@Column(name = "horas_duracion")
	private Integer horasDuracion;
	
	//3
	@JoinColumn(name = "instructor_id")
	@ManyToOne
	private Instructor instructor;
	
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

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Integer getHorasDuracion() {
		return horasDuracion;
	}

	public void setHorasDuracion(Integer horasDuracion) {
		this.horasDuracion = horasDuracion;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	

}
