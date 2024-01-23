package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimenez.app.jpa.dao.IInstructorDao;
import com.jimenez.app.jpa.models.Instructor;

@Service
public class InstructorService implements IService<Instructor>{
	@Autowired
	private IInstructorDao instructorDao;
	

	@Override
	public List<Instructor> listar() {
		List<Instructor> instructor = new ArrayList<Instructor>();
		instructor = (List<Instructor>) instructorDao.findAll();
		return instructor;
	}

	@Override
	public Optional<Instructor> getById(Long id) {
		Optional<Instructor> instructor = instructorDao.findById(id);
		return instructor;
		
	}

	@Override
	public void guardar(Instructor t) {
		this.instructorDao.save(t);	
	}

	@Override
	public void eliminar(Long id) {
		this.instructorDao.deleteById(id);
		
	}

}
