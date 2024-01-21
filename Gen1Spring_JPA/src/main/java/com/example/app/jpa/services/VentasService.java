package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IVentasDao;
import com.example.app.jpa.models.Venta;

@Service
public class VentasService implements IService<Venta>{
	
	@Autowired
	private IVentasDao ventasDao;
	
	@Override
	public List<Venta> listar() {
		List<Venta> ventas = new ArrayList<Venta>();
		ventas = (List<Venta>) ventasDao.findAll();
		return ventas;
	}

	@Override
	public Optional<Venta> getById(Long id) {
		Optional<Venta> ventas = ventasDao.findById(id);
		return ventas;
		
	}

	@Override
	public void guardar(Venta t) {
		this.ventasDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		this.ventasDao.deleteById(id);
		
	}

}
