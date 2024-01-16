package com.jimenez.api.services;

import com.jimenez.api.models.Direccion;

public interface IDireccionesService extends IService<Direccion>{
    Long guardarReturnId(Direccion direccion);
}
