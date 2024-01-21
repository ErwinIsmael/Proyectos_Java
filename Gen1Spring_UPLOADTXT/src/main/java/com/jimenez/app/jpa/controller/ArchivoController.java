package com.jimenez.app.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimenez.app.jpa.Dao.IArchivoDao;
import com.jimenez.app.jpa.models.Archivo;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("/api/archivo")
public class ArchivoController {
	
	@Autowired
	private IService<Archivo> archivoService;
	
	@PostMapping("/subir")
	public Map<String, String> guardar (@RequestBody Archivo a){
		archivoService.guardar(a);
	 	Map<String, String> res = new HashMap<String, String>();
	 	res.put("msg", "Archivo guardado con exito!");
	 	return res;
	}
	
	@GetMapping
	public List<Archivo> listar(){
		return archivoService.listar();
	}
	
	
	

}
