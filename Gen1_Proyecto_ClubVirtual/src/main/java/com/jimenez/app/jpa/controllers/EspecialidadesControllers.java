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

import com.jimenez.app.jpa.models.Especialidad;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("api/especialidades")
public class EspecialidadesControllers {
	
	//atributos
	@Autowired
	IService<Especialidad> especialidadService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Especialidad c){
		especialidadService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Especialidad guardada correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Especialidad> listar(){
		return especialidadService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Especialidad obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Especialidad> especialidad = especialidadService.getById(id);
		if (especialidad.isPresent()) {
			return especialidad.get();
		}else {
			return null;
		}
	}

	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		especialidadService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "La clase fue eliminada con exito!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Especialidad c, @PathVariable(name = "id")Long id ){
		Optional<Especialidad> especialidad = especialidadService.getById(id);
		if(especialidad.isPresent()) {
			c.setId(id);
			especialidadService.guardar(c);
		}
		else {
			throw new RuntimeException("La clase no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Clase actualizada correctamente");
		return respuesta;
	}
}
