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

import com.jimenez.app.jpa.models.Integrante;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/integrantes")
public class IntegrantesControllers {
	
	//atributos
	@Autowired
	IService<Integrante> integrantesService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Integrante c){
		integrantesService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Integrante guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Integrante> listar(){
		return integrantesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Integrante obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Integrante> integrante = integrantesService.getById(id);
		if (integrante.isPresent()) {
			return integrante.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		integrantesService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "El integrante fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Integrante c, @PathVariable(name = "id")Long id ){
		Optional<Integrante> integrante = integrantesService.getById(id);
		if(integrante.isPresent()) {
			c.setId(id);
			integrantesService.guardar(c);
		}
		else {
			throw new RuntimeException("La clase no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Integrante actualizado correctamente");
		return respuesta;
	}
}
