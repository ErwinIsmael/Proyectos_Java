package com.example.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.app.jpa.models.Venta;

public interface IVentasDao extends CrudRepository<Venta, Long>{

}
