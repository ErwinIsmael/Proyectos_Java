package com.jimenez.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimenez.app.jpa.models.Instructor;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/instructores")
public class InstructoresController {
	
	//atributos
	@Autowired
	IService<Instructor> instructorService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Instructor i){
		instructorService.guardar(i);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Instructor guardado correctamente");
		return respuesta;
	}
	

	@GetMapping
	public List<Instructor> listar(){
		return instructorService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Instructor obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Instructor> instructor = instructorService.getById(id);
		if (instructor.isPresent()) {
			return instructor.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		instructorService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "La clase fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Instructor i, @PathVariable(name = "id")Long id ){
		Optional<Instructor> instructor = instructorService.getById(id);
		if(instructor.isPresent()) {
			i.setId(id);
			instructorService.guardar(i);
		}
		else {
			throw new RuntimeException("La clase no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Clase actualizada correctamente");
		return respuesta;
	}

}
