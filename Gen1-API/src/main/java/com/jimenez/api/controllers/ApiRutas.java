package com.jimenez.api.controllers;


import com.google.gson.Gson;
import com.jimenez.api.models.Ruta;
import com.jimenez.api.services.IRutasService;
import com.jimenez.api.services.RutasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/rutas")
public class ApiRutas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IRutasService service = new RutasService(conn);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String camionId = req.getParameter("camionId");
        String choferId = req.getParameter("choferId");
        String direccionOrigenId = req.getParameter("direccionOrigenId");
        String direccionDestinoId = req.getParameter("direccionDestinoId");
        String distancia = req.getParameter("distancia");
        String fechaSalida = req.getParameter("fechaSalida");
        String fechaLlegadaEstimada = req.getParameter("fechaLlegadaEstimada");
        String fechaLlegadaReal = req.getParameter("fechaLlegadaReal");
        String aTiempo = req.getParameter("aTiempo");
        LocalDate fecha;
        LocalDate fechaLlegada;
        LocalDate fechaReal;
        try {
            fechaLlegada = LocalDate.parse(fechaLlegadaEstimada,
                    DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            fecha = LocalDate.parse(fechaSalida,
                    DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            fechaReal = LocalDate.parse(fechaLlegadaReal,
                    DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }catch (DateTimeException e){
            fecha = null;
            fechaLlegada = null;
            fechaReal = null;
        }

        Ruta ruta = new Ruta();
        ruta.setCamionId(Long.valueOf(camionId));
        ruta.setChoferId(Long.valueOf(choferId));
        ruta.setDireccionOrigenId(Long.valueOf(direccionOrigenId));
        ruta.setDireccionDestinoId(Long.valueOf(direccionDestinoId));
        ruta.setDistancia(Float.valueOf(distancia));
        ruta.setFechaSalida(fecha);
        ruta.setFechaLlegadaEstimada(fechaLlegada);
        ruta.setFechaLlegadaReal(fechaReal);
        ruta.setaTiempo(Boolean.valueOf(aTiempo));


        resp.setContentType("application/json");
        Map<String, String> respuesta = new HashMap<>();
        if (camionId == null || choferId == null || direccionOrigenId == null ||
                direccionDestinoId == null || distancia == null || fechaSalida == null
                || fechaLlegadaEstimada == null || fechaLlegadaReal == null || aTiempo == null){
            try (PrintWriter out = resp.getWriter()){
                resp.setStatus(400);
                respuesta.put("message", "Debes ingresar todos los valores");
                respuesta.put("estatus","error");
                String json = new Gson().toJson(respuesta);
                out.println(json);
            }
        }
        else {
            Long id = service.guardarReturnId(ruta);
            try (PrintWriter out = resp.getWriter()){
                resp.setStatus(201);
                respuesta.put("message", id.toString());
                respuesta.put("estatus", "success");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }
    }
}
