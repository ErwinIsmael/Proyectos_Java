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

@Table(name = "bc_especialidadesObtenidas")
@Entity
public class EspecialidadObtenida {
	//atributos -> varibales -> caracteristicas
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ4")
	@SequenceGenerator(sequenceName = "clubvirtual_seq4", allocationSize = 1, name = "BC_SEQ4")
	private Long id;
	
	//2 
	@JoinColumn(name = "integrante_id")
	@ManyToOne
	private Integrante integrante;
	
	//2
	@JoinColumn(name = "especialidad_id")
	@ManyToOne
	private Especialidad especialidad;
	
	//Getter and setter
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

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	
	
	
	

}
