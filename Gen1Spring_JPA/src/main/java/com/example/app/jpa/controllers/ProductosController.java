package com.example.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.jpa.models.Producto;
import com.example.app.jpa.services.IService;
import com.example.app.jpa.services.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
	
	//atributos
	@Autowired
	IService<Producto> productosService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Producto p){
		productosService.guardar(p);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "LEl producto fue guardado con exito!");
		return respuesta;
	}
	
	@GetMapping
	public List<Producto> listar(){
		return productosService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Producto obtenerId(@PathVariable(name = "id") Long id) {
		Optional<Producto> producto = productosService.getById(id);
		if (producto.isPresent()) {
			return producto.get();
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam (name = "id")Long id){
		productosService.eliminar(id);
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("msg", "Se ha eliminado correctamente el producto con id: "+id);
		return resultado;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Producto p, @PathVariable (name = "id")Long id){
		Optional<Producto> producto = productosService.getById(id);
		if(producto.isPresent()) {
			p.setId(id);
			productosService.guardar(p);
		}
		else {
			throw new RuntimeException("El producto no existe en la BD!");
		}
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("msg", "El registro Se ha actualizado con exito!");
		return resultado;
	}
	
	

}
