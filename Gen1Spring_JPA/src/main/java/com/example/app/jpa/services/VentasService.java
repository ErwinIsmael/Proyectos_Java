package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IClientesDao;
import com.example.app.jpa.dao.IVentasDao;
import com.example.app.jpa.dtos.DetalleVentaListDTO;
import com.example.app.jpa.dtos.VentaDTO;
import com.example.app.jpa.dtos.VentaListDTO;
import com.example.app.jpa.models.DetalleVenta;
import com.example.app.jpa.models.Venta;

@Service
public class VentasService implements IService<VentaListDTO, VentaDTO>
{
	@Autowired
	private IVentasDao ventasDao;
	@Autowired
	private IClientesDao clientesDao;

	@Override
	public List<VentaListDTO> listar() 
	{
		List<Venta> ventas = new ArrayList<>();
		ventas = (List<Venta>) ventasDao.findAll();
		
		return ventas.stream().map((v) -> {
			return this.convertirVentaADTO(v);
					}).toList();
	}

	@Override
	public Optional<VentaListDTO> getById(Long id) 
	{
		// TODO Auto-generated method stub
		Optional<Venta> ventas = ventasDao.findById(id);
		return Optional.of(this.convertirVentaADTO(ventas.get()));
	}

	@Override
	public void guardar(VentaDTO t) 
	{
		// TODO Auto-generated method stub
		
		this.ventasDao.save(convertirDTOaVenta(t));
		
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.ventasDao.deleteById(id);
		
	}
	
	//metodo parfa converir DTO en un modelo original
	public Venta convertirDTOaVenta(VentaDTO ventadto)
	{
		Venta v = new Venta();
		v.setId(ventadto.getId());
		v.setFecha(ventadto.getFecha());
		v.setSubtotal(ventadto.getSubtotal());
		v.setTotal(ventadto.getTotal());
		v.setDescuento(ventadto.getDescuento());
		v.setFormaPago(ventadto.getFormaPago());
		v.setCliente(clientesDao.findById(ventadto.getCliente()).get());
		return v;
	}
	
	
	public VentaListDTO convertirVentaADTO(Venta v) {
		VentaListDTO vdto = new VentaListDTO();
		vdto.setId(v.getId());
		vdto.setFecha(v.getFecha());
		vdto.setSubtotal(v.getSubtotal());
		vdto.setDescuento(v.getDescuento());
		vdto.setTotal(v.getTotal());
		vdto.setFormaPago(v.getFormaPago());
		vdto.setCliente(v.getCliente());
		
		List<DetalleVentaListDTO> detalle = new ArrayList<>();
		for (DetalleVenta dv : v.getDetalle()) {
			DetalleVentaListDTO dvdto = new DetalleVentaListDTO();
			dvdto.setId(dv.getId());
			dvdto.setCantidad(dv.getCantidad());
			dvdto.setProducto(dv.getProducto());
			detalle.add(dvdto);
		}
		vdto.setDetalle(detalle);
		return vdto;
	}
	
}

