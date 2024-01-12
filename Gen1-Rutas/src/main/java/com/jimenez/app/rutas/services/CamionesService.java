package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Camion;
import com.jimenez.app.rutas.repositories.CamionesRepository;
import com.jimenez.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CamionesService implements IService<Camion>{
    //atributos
    private IRepository<Camion> CamionesRepo;

    //constructor
    public CamionesService(Connection conn) {
        CamionesRepo = new CamionesRepository(conn);
    }

    @Override
    public List<Camion> listar() {
        try {
            return CamionesRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Camion> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Camion camion) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
