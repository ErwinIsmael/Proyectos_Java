package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Escuela;
import com.jimenez.app.rutas.repositories.EscuelasRepository;
import com.jimenez.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EscuelaService implements IService<Escuela> {
    private IRepository<Escuela> escuelaRepo;
    public EscuelaService(Connection conn) {
        escuelaRepo = new EscuelasRepository(conn);

    }
    @Override
    public List<Escuela> listar() {
        try {
            return escuelaRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public Optional<Escuela> getById(Long id) {
        try {
            return Optional.ofNullable(escuelaRepo.getById(id));
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void guardar(Escuela escuela) {
        try {
            escuelaRepo.guardar(escuela);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(),e.getCause());
        }

    }

    @Override
    public void eliminar(Long id) {
        try {
            escuelaRepo.eliminar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(),e.getCause());
        }

    }
}
