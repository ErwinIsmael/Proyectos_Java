package com.example.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.app.jpa.models.DetalleVenta;

public interface IDetallesVentasDao extends CrudRepository<DetalleVenta, Long>{

}
