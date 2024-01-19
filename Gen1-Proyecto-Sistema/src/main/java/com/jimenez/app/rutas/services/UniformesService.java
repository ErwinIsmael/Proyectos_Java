package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Uniforme;
import com.jimenez.app.rutas.repositories.IRepository;
import com.jimenez.app.rutas.repositories.UniformesRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UniformesService implements IService<Uniforme>{

    private IRepository<Uniforme> uniformesRepo;
    public UniformesService(Connection connection) {
        uniformesRepo = new UniformesRepository(connection);

    }

    @Override
    public List<Uniforme> listar() {
        try {
            return uniformesRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Uniforme> getById(Long id) {
        try {
            return Optional.ofNullable(uniformesRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Uniforme uniforme) {
        try {
            uniformesRepo.guardar(uniforme);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(Long id) {
        try {
            uniformesRepo.eliminar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }


}
