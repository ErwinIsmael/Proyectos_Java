package com.example.app.jpa.controllers;

import java.util.ArrayList;
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

import com.example.app.jpa.dao.IDetallesVentasDao;
import com.example.app.jpa.models.DetalleVenta;
import com.example.app.jpa.services.IService;

@RestController
@RequestMapping("api/detalleVentas")
public class DetalleVentasController{
	
	@Autowired
	IService<DetalleVenta> detatalleService;
	
	@GetMapping
	public List<DetalleVenta> listar(){
		return detatalleService.listar();
	}
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody DetalleVenta ds){
		detatalleService.guardar(ds);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "El detalle de ventas guardado correctamente!");
		return respuesta;
	}
	
	@GetMapping("/obtener/{id}")
	public DetalleVenta obtenerPorId(@PathVariable(name = "id")Long id) {
		Optional<DetalleVenta> detalleVenta = detatalleService.getById(id);
		if(detalleVenta.isPresent()) {
			return detalleVenta.get();
		}else {
			return null;
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam(name = "id")Long id){
		detatalleService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Detalle Venta Eliminado correctamente!");
		return respuesta;
	}
	
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody DetalleVenta dc, @PathVariable (name = "id")Long id){
		Optional<DetalleVenta> detalleVenta = detatalleService.getById(id);
		if (detalleVenta.isPresent()) {
			dc.setId(id);
			detatalleService.guardar(dc);
		}else {
			throw new RuntimeException("El detalle Venta no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Detalle Venta actualizado correctamente");
		return respuesta;
	}
	

}
