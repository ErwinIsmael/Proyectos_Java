package com.jimenez.api.repositories;

import com.jimenez.api.models.Ruta;

import java.sql.SQLException;

public interface IRutasRepository extends IRepository<Ruta>{
    Long guardarReturnId(Ruta ruta) throws SQLException;

}
