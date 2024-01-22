package com.jimenez.app.jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "bc_inscripciones")
@Entity
public class Inscripcion {
	//atributos
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ6")
	@SequenceGenerator(sequenceName = "clubvirtual_seq6",allocationSize = 1, name = "BC_SEQ6")
	private Long id;
	
	//3
	@JoinColumn(name = "integrante_id")
	@ManyToOne
	private Integrante integrante;
	
	//3
	@JoinColumn(name = "clase_id")
	@ManyToOne
	private Clase clase;
	
	//2
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	//2 
	@Column(name = "status")
	private Integer status;
	
	
	//getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
