package com.jimenez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.Instructor;

public interface IInstructorDao extends CrudRepository<Instructor, Long>{

}
