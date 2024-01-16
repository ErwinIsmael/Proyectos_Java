package com.jimenez.api.repositories;


import com.jimenez.api.models.Direccion;

import java.sql.SQLException;

public interface IDireccionesRepository extends IRepository<Direccion> {
    Long guardarReturnId(Direccion direccion) throws SQLException;


}
