package com.jimenez.api.controllers;

import com.google.gson.Gson;
import com.jimenez.api.models.Direccion;
import com.jimenez.api.services.DireccionesService;
import com.jimenez.api.services.IDireccionesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/direcciones")
public class ApiDirecciones extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IDireccionesService service = new DireccionesService(conn);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String calle = req.getParameter("calle");
        String numero = req.getParameter("numero");
        String colonia = req.getParameter("colonia");
        String ciudad = req.getParameter("ciudad");
        String estado = req.getParameter("estado");
        String cp = req.getParameter("cp");


        Direccion direccion = new Direccion();
        direccion.setCalle(calle);
        direccion.setNumero(numero);
        direccion.setColonia(colonia);
        direccion.setCiudad(ciudad);
        direccion.setEstado(estado);
        direccion.setCp(cp);

        resp.setContentType("application/json");
        Map<String, String> respuesta = new HashMap<>();
        if (calle == null || numero == null || colonia == null || ciudad == null
            || estado == null || cp == null){
            try (PrintWriter out = resp.getWriter()){
                resp.setStatus(400);
                respuesta.put("message", "Debes ingresar todos los valores");
                respuesta.put("estatus","error");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }
        else {
            Long id = service.guardarReturnId(direccion);
            try (PrintWriter out = resp.getWriter()) {
                resp.setStatus(201);
                respuesta.put("message", id.toString());
                respuesta.put("estatus", "success");
                String json = new  Gson().toJson(respuesta);
                out.print(json);

            }
        }
    }

}
