package com.example.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.app.jpa.models.Producto;

public interface IProductosDao extends CrudRepository<Producto, Long>{

}
