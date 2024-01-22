package com.jimenez.app.jpa.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jimenez.app.jpa.models.Archivo;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping("/api/archivo")
public class ArchivoController {

    @Autowired
    private IService<Archivo> archivoService;

    @PostMapping("/subir")
    public ResponseEntity<Map<String, String>> guardar(@RequestBody Archivo archivo) {
        try {
            // Decodificar la cadena Base64 y almacenarla en el campo Blob
            archivo.setDataFromBase64();

            archivoService.guardar(archivo);

            Map<String, String> res = new HashMap<>();
            res.put("msg", "Archivo guardado con éxito!");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Error al subir el archivo.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
}
