package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimenez.app.jpa.dao.IInscripcionDao;
import com.jimenez.app.jpa.models.Inscripcion;

@Service
public class InscripcionService implements IService<Inscripcion>{
	@Autowired
	private IInscripcionDao inscripcionDao;

	@Override
	public List<Inscripcion> listar() {
		List<Inscripcion> inscripcion = new ArrayList<Inscripcion>();
		inscripcion = (List<Inscripcion>) inscripcionDao.findAll();
		return inscripcion;
	}

	@Override
	public Optional<Inscripcion> getById(Long id) {
		Optional<Inscripcion> inscripcion = inscripcionDao.findById(id);
		return inscripcion;
	}

	@Override
	public void guardar(Inscripcion t) {
		this.inscripcionDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		this.inscripcionDao.deleteById(id);

	}

}
