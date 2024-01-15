package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Direccion;

public interface IDireccionesService extends IService<Direccion>{
    Long guardarReturnId(Direccion direccion);
}
