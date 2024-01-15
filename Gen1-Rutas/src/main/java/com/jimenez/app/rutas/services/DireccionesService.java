package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Direccion;
import com.jimenez.app.rutas.repositories.DireccionesRepository;
import com.jimenez.app.rutas.repositories.IDireccionesRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DireccionesService implements IDireccionesService{
    private IDireccionesRepository direccionesRepo;
    public DireccionesService(Connection conexion){
        direccionesRepo = new DireccionesRepository(conexion);
    }
    @Override
    public Long guardarReturnId(Direccion direccion) {
        try {
            return direccionesRepo.guardarReturnId(direccion);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Direccion> listar() {
        return null;
    }

    @Override
    public Optional<Direccion> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Direccion direccion) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
