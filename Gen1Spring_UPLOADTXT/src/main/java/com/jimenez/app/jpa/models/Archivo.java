package com.jimenez.app.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "jpa_archivos")
@Entity
public class Archivo {
	
	@Column(name = "id")
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ1")
	@SequenceGenerator(sequenceName = "file_se1", allocationSize = 1, name = "CUST_SEQ3")
	private Long id;
	
	
	@Lob
	@Column(name = "file")
	private byte[] data;
	
	
	

	
	
	
	
}
