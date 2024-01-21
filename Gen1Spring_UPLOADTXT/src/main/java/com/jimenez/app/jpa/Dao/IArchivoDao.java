package com.jimenez.app.jpa.Dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.Archivo;

public interface IArchivoDao extends CrudRepository<Archivo, Long> {


}
