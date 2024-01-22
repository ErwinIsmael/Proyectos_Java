package com.example.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.jpa.models.Cliente;
import com.example.app.jpa.services.IService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/clientes")
public class ClientesController {
	
	//atributos
	@Autowired
	IService<Cliente,Cliente> clientesService;
	
	@PostMapping
	public Map<String, String> guardar (@RequestBody Cliente c){
		clientesService.guardar(c);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Clientes guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Cliente> listar() {
		return clientesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Cliente obtenerPorId (@PathVariable(name = "id")Long id) {
		Optional<Cliente> cliente = clientesService.getById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar (@RequestParam(name = "id") Long id){
		clientesService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente eliminado correctamente");
		return respuesta;
	}
	
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar (@RequestBody Cliente c, @PathVariable(name = "id") Long id){
		Optional<Cliente> cliente = clientesService.getById(id);
		if (cliente.isPresent()) {
			
			c.setId(id);
			clientesService.guardar(c);
		}
		else {
			throw new RuntimeException("El cliente no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg","Cliente actualizado correctamente");
		return respuesta;
	}
	
	
	
	

}
