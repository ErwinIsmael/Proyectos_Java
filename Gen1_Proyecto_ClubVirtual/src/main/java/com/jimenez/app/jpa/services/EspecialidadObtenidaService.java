package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jimenez.app.jpa.dao.IEspecialidadObtenidaDao;
import com.jimenez.app.jpa.models.EspecialidadObtenida;

@Service
public class EspecialidadObtenidaService implements IService<EspecialidadObtenida>{

	@Autowired
	private IEspecialidadObtenidaDao especialidadObtenidaDao;
	
	
	@Override
	public List<EspecialidadObtenida> listar() {
		List<EspecialidadObtenida> especialidadObtenida = new ArrayList<EspecialidadObtenida>();
		especialidadObtenida = (ArrayList<EspecialidadObtenida>) especialidadObtenidaDao.findAll();
		return especialidadObtenida;
	}

	@Override
	public Optional<EspecialidadObtenida> getById(Long id) {
		Optional<EspecialidadObtenida> especialidadObtenida = especialidadObtenidaDao.findById(id);
		return especialidadObtenida;
	}

	@Override
	public void guardar(EspecialidadObtenida t) {
		this.especialidadObtenidaDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.especialidadObtenidaDao.deleteById(id);
		
	}

}
