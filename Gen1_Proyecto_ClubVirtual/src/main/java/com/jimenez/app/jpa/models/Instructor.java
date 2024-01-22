package com.jimenez.app.jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "bc_instructores")
@Entity
public class Instructor {
	
	//atributos -> variables -> caracteristicas
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ2")
	@SequenceGenerator(sequenceName = "clubvirtual_seq2", allocationSize = 1, name = "BC_SEQ2")
	private Long id;
	
	//2
	@Column(name = "num_trabajador")
	private String numTrabajador;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	//2
	@Column(name = "ap_materno")
	private String apMaterno;
	
	//2
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	//2
	@Column(name = "telefono")
	private String telefono;
	
	//2 
	@Column(name = "email")
	private String email;

	//getter and setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumTrabajador() {
		return numTrabajador;
	}

	public void setNumTrabajador(String numTrabajador) {
		this.numTrabajador = numTrabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
		
}
