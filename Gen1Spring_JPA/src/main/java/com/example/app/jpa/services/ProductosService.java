package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IProductosDao;
import com.example.app.jpa.models.Producto;

@Service
public class ProductosService implements IService<Producto>{
	
	@Autowired
	private IProductosDao productosDao;
	

	@Override
	public List<Producto> listar() {
		List<Producto> producto = new ArrayList<Producto>();
		producto = (ArrayList<Producto>) productosDao.findAll();
		return producto;
	}

	@Override
	public Optional<Producto> getById(Long id) {
		Optional<Producto> producto = productosDao.findById(id);
		return producto;
	}

	@Override
	public void guardar(Producto t) {
		this.productosDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		this.productosDao.deleteById(id);
		
	}
	

}
