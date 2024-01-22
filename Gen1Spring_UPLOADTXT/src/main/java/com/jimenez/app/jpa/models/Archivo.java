package com.jimenez.app.jpa.models;

import org.apache.tomcat.util.codec.binary.Base64;

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

	 @Column(name = "base64_contenido")
	    private String base64Contenido;

	    // Constructor, getters y setters...

	    // Método para establecer los datos desde una cadena Base64
	    public void setDataFromBase64() {
	        this.data = Base64.decodeBase64(this.base64Contenido);
	    }

	    // Getter y Setter para el campo base64Contenido
	    public String getBase64Contenido() {
	        return base64Contenido;
	    }

	    public void setBase64Contenido(String base64Contenido) {
	        this.base64Contenido = base64Contenido;
	    }
	
		
	
	
}
