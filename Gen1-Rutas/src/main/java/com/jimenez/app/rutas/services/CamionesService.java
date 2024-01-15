package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Camion;
import com.jimenez.app.rutas.models.enums.Marcas;
import com.jimenez.app.rutas.repositories.CamionesRepository;
import com.jimenez.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CamionesService implements IService<Camion>{
    //atributos
    private IRepository<Camion> CamionesRepo;
    //constructor
    public CamionesService(Connection conn) {
        CamionesRepo = new CamionesRepository(conn);
    }

    public List<Marcas> mostrar(){
        List<Marcas> marcas = new ArrayList<>();
        Marcas[] enummarca = Marcas.values();
        for (int i = 0; i < enummarca.length; i++) {
            System.out.println(enummarca[i]);
            marcas.add(enummarca[i]);
        }
        return marcas;
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
        try {
            return Optional.ofNullable(CamionesRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Camion camion) {
        try {
            CamionesRepo.guardar(camion);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(Long id) {
        try {
            CamionesRepo.eliminar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }
}
