package com.example.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.app.jpa.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long>{
	
	

}
