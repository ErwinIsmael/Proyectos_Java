package com.jimenez.api.services;

import com.jimenez.api.models.Ruta;
import com.jimenez.api.repositories.IRutasRepository;
import com.jimenez.api.repositories.RutasRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RutasService implements IRutasService{
    private IRutasRepository rutasRepo;
    public RutasService(Connection connexion) { rutasRepo = new RutasRepository(connexion); }

    @Override
    public Long guardarReturnId(Ruta ruta) {
        try {
            return rutasRepo.guardarReturnId(ruta);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public List<Ruta> listar() {
        return null;
    }

    @Override
    public Optional<Ruta> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Ruta ruta) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
