package com.jimenez.app.rutas.controllers;

import com.google.gson.Gson;
import com.jimenez.app.rutas.models.Cargamento;
import com.jimenez.app.rutas.models.Ruta;
import com.jimenez.app.rutas.services.IRutasService;
import com.jimenez.app.rutas.services.RutasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/rutas/alta")
public class AltaRutaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn"); //recupera la conexion
        IRutasService service = new RutasService(conn);//se crea el servicio
        req.setAttribute("camiones", service.listarCamiones()); //se asocia el valor de lo que regrese lista
        req.setAttribute("choferes", service.listarChoferes()); // lo mismo hacer lo que la funcion solicite

        HttpSession session = req.getSession(); //
        List<Cargamento> cargamentos = (List<Cargamento>) session.getAttribute("cargamentos");
        req.setAttribute("cargamentos", cargamentos);

        getServletContext().getRequestDispatcher("/altaRuta.jsp").forward(req,resp); //devolver la vista que vamos a pintar, altaRuta.jsp


    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IRutasService service = new RutasService(conn);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        String choferId = req.getParameter("choferId");
        String direccionOrigenId = req.getParameter("direccionOrigenId");
        String fechaSalida = req.getParameter("fechaSalida");
        String distancia = req.getParameter("distancia");
        String camionId = req.getParameter("camoinId");
        String direccionDestinoId = req.getParameter("direccionDestinoId");
        String capCamion = req.getParameter("capCamion");
        String fechaLlegadaEstimada =req.getParameter("fechaLlegadaEstimada");

        LocalDate salidaFecha = LocalDate.parse(fechaSalida);
        String FechaFormat = salidaFecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechaLlegada = LocalDate.parse(fechaLlegadaEstimada);
        String FechaFormatLlegada = fechaLlegada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        try {

            salidaFecha = LocalDate.parse(FechaFormat,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeException e){
            salidaFecha = null;

        }
        try {

            fechaLlegada = LocalDate.parse(FechaFormatLlegada,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeException e){
            fechaLlegada = null;
        }

        Ruta ruta = new Ruta();
        ruta.setId(0L);
        ruta.setCamionId(Long.parseLong(camionId));
        ruta.setChoferId(Long.parseLong(choferId));
        ruta.setDireccionOrigenId(Long.parseLong(direccionOrigenId));
        ruta.setDireccionDestinoId(Long.parseLong(direccionDestinoId));
        ruta.setDistancia(Float.valueOf(distancia));
        ruta.setFechaSalida(salidaFecha);
        ruta.setFechaLlegadaEstimada(fechaLlegada);
        ruta.setFechaLlegadaReal(fechaLlegada);
        ruta.setaTiempo(1);


        resp.setContentType("application/json");
        Map<String, String> respuesta = new HashMap<>();
        if (camionId == null || choferId == null || direccionOrigenId == null ||
                direccionDestinoId == null || distancia == null || fechaSalida == null || capCamion == null || fechaLlegadaEstimada == null){
            try (PrintWriter out = resp.getWriter()){
                resp.setStatus(400);
                respuesta.put("message", "Debes ingresar todos los valores");
                respuesta.put("status","error");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }
        else {
            Long id = service.guardarReturnId(ruta);
            try (PrintWriter out = resp.getWriter()){
                resp.setStatus(201);
                respuesta.put("message", id.toString());
                respuesta.put("status", "success");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }
    }

    }

