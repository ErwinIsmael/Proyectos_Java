package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimenez.app.jpa.dao.IClaseDao;
import com.jimenez.app.jpa.models.Clase;

@Service
public class ClasesService implements IService<Clase>{

	@Autowired
	private IClaseDao clasesDao;
	
	
	@Override
	public List<Clase> listar() {
		List<Clase> clases = new ArrayList<Clase>();
		clases = (List<Clase>) clasesDao.findAll();
		return clases;
	}

	@Override
	public Optional<Clase> getById(Long id) {
		Optional<Clase> clase = clasesDao.findById(id);
		return clase;
	}

	@Override
	public void guardar(Clase t) {
		this.clasesDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.clasesDao.deleteById(id);
	}
	
	

}
