package com.example.app.jpa.controllers;

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

import com.example.app.jpa.models.Venta;
import com.example.app.jpa.services.IService;

@RestController
@RequestMapping("api/ventas")
public class VentasController {
	
	@Autowired
	IService<Venta> ventasService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Venta v){
		ventasService.guardar(v);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Venta registrada!");
		return respuesta;
	}
	
	@GetMapping
	public List<Venta> listar(){
		return ventasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Venta obtenerPorId(@PathVariable (name = "id") Long id){
		Optional<Venta> venta = ventasService.getById(id);
		if (venta.isPresent()) {
			return venta.get();
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id") Long id){
		ventasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Se elimino correctamente!");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Venta v, @PathVariable(name = "id") Long id){
		Optional<Venta> venta = ventasService.getById(id);
		if (venta.isPresent()) {
			v.setId(id);
			ventasService.guardar(v);
		} else {
			throw new RuntimeException("La venta no existe en la BD!");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta actualizada correctamente");
		return respuesta;
	}
}
