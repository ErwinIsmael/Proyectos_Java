package com.jimenez.app.jpa.services;

import java.util.List;

public interface IService<T> {
	List<T> listar();
	void guardar(T t);
	

}
