package com.example.app.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.app.jpa.models.Cliente;

@Service
@Qualifier("nuevo")
public class ClientesServiceNuevo implements IService<Cliente, Cliente>{
	
	
	

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
