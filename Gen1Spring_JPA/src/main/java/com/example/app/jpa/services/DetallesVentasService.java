package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IDetallesVentasDao;
import com.example.app.jpa.models.DetalleVenta;

@Service
public class DetallesVentasService implements IService<DetalleVenta>{
	
	@Autowired
	private IDetallesVentasDao detallesVentaDao;

	@Override
	public List<DetalleVenta> listar() {
		List<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
		detalleVentas = (List<DetalleVenta>) detallesVentaDao.findAll();
		return detalleVentas;
	}

	@Override
	public Optional<DetalleVenta> getById(Long id) {
		Optional<DetalleVenta> detalleVenta = detallesVentaDao.findById(id);
		return detalleVenta;
	}

	@Override
	public void guardar(DetalleVenta t) {
		this.detallesVentaDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		this.detallesVentaDao.deleteById(id);
	}

}
