package com.jimenez.app.jpa.models;

import java.util.Date;

import com.jimenez.app.jpa.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "bc_integrantes")
@Entity
public class Integrante {
	//atributos de la tabla -> variables -> caracteristicas
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BC_SEQ1")
	@SequenceGenerator(sequenceName = "clubvirtual_seq1", allocationSize = 1, name = "BC_SEQ1")
	private Long id;
	
	
	//2 
	@Column(name = "matricula")
	private String matricula;
	
	//2
	@Column(name = "nombre")
	private String nombre;
	
	//2 
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	//2 
	@Column(name = "ap_Materno")
	private String apMaterno;
	
	//2
	@Column(name = "genero")
	private Genero genero;
	
	//2
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	//2
	@Column(name = "email")
	private String email;
	
	//2 
	@Column(name = "telefono")
	private String telefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
