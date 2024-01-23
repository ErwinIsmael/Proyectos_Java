package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimenez.app.jpa.dao.IEspecialidadDao;
import com.jimenez.app.jpa.models.Especialidad;

@Service
public class EspecialidadService implements IService<Especialidad>{
	
	@Autowired
	private IEspecialidadDao especialidadDao;
	
	@Override
	public List<Especialidad> listar() {
		List<Especialidad> especialidad = new ArrayList<>();
		especialidad = (ArrayList<Especialidad>) especialidadDao.findAll();
		return especialidad;
	}

	@Override
	public Optional<Especialidad> getById(Long id) {
		Optional<Especialidad> especialidad = especialidadDao.findById(id);
		return especialidad;
	}

	@Override
	public void guardar(Especialidad t) {
		this.especialidadDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.especialidadDao.deleteById(id);
	}
	

}
