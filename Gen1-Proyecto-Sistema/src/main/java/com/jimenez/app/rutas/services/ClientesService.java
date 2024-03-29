package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Cliente;
import com.jimenez.app.rutas.repositories.ClientesRepository;
import com.jimenez.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientesService implements IService<Cliente>{
    //atributos
    private IRepository<Cliente> clientesRepo;


    //Constructor
    public ClientesService(Connection conn) {
        clientesRepo = new ClientesRepository(conn);
    }


    @Override
    public List<Cliente> listar() {
        try {
            return clientesRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        try {
            return Optional.ofNullable(clientesRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Cliente cliente) {
        try {
            clientesRepo.guardar(cliente);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(Long id) {
        try {
            clientesRepo.eliminar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
