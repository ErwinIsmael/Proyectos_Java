package com.jimenez.api.services;

import com.jimenez.api.models.Ruta;

public interface IRutasService extends IService<Ruta>{
    Long guardarReturnId(Ruta ruta);
}
