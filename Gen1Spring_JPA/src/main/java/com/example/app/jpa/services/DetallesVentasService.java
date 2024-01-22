package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IDetallesVentasDao;
import com.example.app.jpa.dao.IProductosDao;
import com.example.app.jpa.dao.IVentasDao;
import com.example.app.jpa.dtos.DetalleVentaDTO;
import com.example.app.jpa.models.DetalleVenta;

@Service
public class DetallesVentasService implements IService<DetalleVenta, DetalleVentaDTO>{
	
	@Autowired
	private IDetallesVentasDao detallesVentaDao;
	@Autowired
	private IProductosDao productosDao;
	@Autowired
	private IVentasDao ventasDao;

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
	public void guardar(DetalleVentaDTO t) {
		this.detallesVentaDao.save(convertidorDTODetalleVenta(t));
	}

	@Override
	public void eliminar(Long id) {
		this.detallesVentaDao.deleteById(id);
	}
	
	
	public DetalleVenta convertidorDTODetalleVenta(DetalleVentaDTO detalleVentadto) {
		DetalleVenta d = new DetalleVenta();
		d.setId(detalleVentadto.getId());
		d.setCantidad(detalleVentadto.getCantidad());
		d.setProducto(productosDao.findById(detalleVentadto.getProducto()).get());
		d.setVenta(ventasDao.findById(detalleVentadto.getVenta()).get());
		return d;
	}
	

}
