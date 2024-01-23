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

import com.jimenez.app.jpa.models.EspecialidadObtenida;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/especialidadesObtenidas")
public class EspecialidadObtenidaControllers {
	
	//atributos
	@Autowired
	IService<EspecialidadObtenida> especialidadObtenidaService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody EspecialidadObtenida c){
		especialidadObtenidaService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Clase guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<EspecialidadObtenida> listar(){
		return especialidadObtenidaService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public EspecialidadObtenida obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<EspecialidadObtenida> eObtenida = especialidadObtenidaService.getById(id);
		if (eObtenida.isPresent()) {
			return eObtenida.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		especialidadObtenidaService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "La clase fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody EspecialidadObtenida c, @PathVariable(name = "id")Long id ){
		Optional<EspecialidadObtenida> eObtenida = especialidadObtenidaService.getById(id);
		if(eObtenida.isPresent()) {
			c.setId(id);
			especialidadObtenidaService.guardar(c);
		}
		else {
			throw new RuntimeException("La clase no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Clase actualizada correctamente");
		return respuesta;
	}
}
