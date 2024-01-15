package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Direccion;

import java.sql.SQLException;

public interface IDireccionesRepository extends IRepository<Direccion> {
    Long guardarReturnId(Direccion direccion) throws SQLException;


}
