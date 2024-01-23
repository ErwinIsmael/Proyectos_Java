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

import com.jimenez.app.jpa.models.Clase;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/clases")
public class ClasesController {
	
	//atributos
	@Autowired
	IService<Clase> clasesService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Clase c){
		clasesService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Clase guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Clase> listar(){
		return clasesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Clase obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Clase> clase = clasesService.getById(id);
		if (clase.isPresent()) {
			return clase.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		clasesService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "La clase fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Clase c, @PathVariable(name = "id")Long id ){
		Optional<Clase> clase = clasesService.getById(id);
		if(clase.isPresent()) {
			c.setId(id);
			clasesService.guardar(c);
		}
		else {
			throw new RuntimeException("La clase no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Clase actualizada correctamente");
		return respuesta;
	}
}
