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

import com.jimenez.app.jpa.models.Inscripcion;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/inscripciones")
public class InscripcionesControllers {
	
	//atributos
	@Autowired
	IService<Inscripcion> inscripcionService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Inscripcion c){
		inscripcionService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Inscricion realizada correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Inscripcion> listar(){
		return inscripcionService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Inscripcion obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Inscripcion> inscripcion = inscripcionService.getById(id);
		if (inscripcion.isPresent()) {
			return inscripcion.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		inscripcionService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "La inscripcion fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Inscripcion c, @PathVariable(name = "id")Long id ){
		Optional<Inscripcion> inscripcion = inscripcionService.getById(id);
		if(inscripcion.isPresent()) {
			c.setId(id);
			inscripcionService.guardar(c);
		}
		else {
			throw new RuntimeException("La inscripcion no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Inscripcion actualizada correctamente");
		return respuesta;
	}
}
