package com.example.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.jpa.dao.IClientesDao;
import com.example.app.jpa.models.Cliente;

@Service
public class ClientesService implements IService<Cliente>{
	
	@Autowired
	private IClientesDao clientesDao;

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (List<Cliente>) clientesDao.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		Optional<Cliente> cliente = clientesDao.findById(id);
		return cliente;
	}

	@Override
	public void guardar(Cliente t) {
		// TODO Auto-generated method stub
		this.clientesDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.clientesDao.deleteById(id);
	}
	

}