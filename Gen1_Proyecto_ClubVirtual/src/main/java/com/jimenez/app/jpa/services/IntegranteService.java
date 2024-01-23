package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimenez.app.jpa.dao.IIntegranteDao;
import com.jimenez.app.jpa.models.Integrante;

@Service
public class IntegranteService implements IService<Integrante>{
	@Autowired
	private IIntegranteDao integranteDao;

	@Override
	public List<Integrante> listar() {
		List<Integrante> integrante = new ArrayList<Integrante>();
		integrante = (List<Integrante>) integranteDao.findAll();
		return integrante;
	}

	@Override
	public Optional<Integrante> getById(Long id) {
		Optional<Integrante> integrante = integranteDao.findById(id);
		return integrante;
	}

	@Override
	public void guardar(Integrante t) {
		this.integranteDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.integranteDao.deleteById(id);
	}
	
	

}
