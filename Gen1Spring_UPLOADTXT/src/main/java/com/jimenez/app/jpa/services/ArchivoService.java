package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jimenez.app.jpa.Dao.IArchivoDao;
import com.jimenez.app.jpa.models.Archivo;

public class ArchivoService implements IService<Archivo>{

	@Autowired
	private IArchivoDao archivoDao; 
	
	
	@Override
	public List<Archivo> listar() {
		List<Archivo> archivo = new ArrayList<Archivo>();
		archivo = (List<Archivo>) archivoDao.findAll();
		return archivo;
	}

	@Override
	public void guardar(Archivo t) {
		this.archivoDao.save(t);
		
	}
	

}
