package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Chofer;
import com.jimenez.app.rutas.services.ChoferesService;
import com.jimenez.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/choferes/alta")
public class AltaChoferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaChofer.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Chofer> service = new ChoferesService(conn);

        String nombre = req.getParameter("nombre"); // "QQQQQ"
        String apPaterno = req.getParameter("apPaterno"); // tttttttttttttt
        String apMaterno = req.getParameter("apMaterno");//jdblksajgblvkjhd
        String licencia = req.getParameter("licencia"); //lihobdksjbvs
        String telefono = req.getParameter("telefono");//'3253453453'
        String fechaNacimiento = req.getParameter("fechaNacimiento"); // 01-01-2023

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaNacimiento,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeException e){
            fecha = null;
        }
        String checkbox[]; //[]
        checkbox = req.getParameterValues("disponibilidad");
        Boolean habilitar;
        if (checkbox != null){
            habilitar = true;
        }else {
            habilitar = false;
        }
        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre","el nombre es requerido!");
        }
        if (apPaterno == null || apPaterno.isBlank()){
            errores.put("apPaterno", "el apellido paterno es requerido!");
        }
        if (apMaterno == null || apMaterno.isBlank()){
            errores.put("apMaterno", "el apellido materno es requerido!");
        }
        if (licencia == null || licencia.isBlank()){
            errores.put("licencia", "la licencia es requerido!");
        }
        if (telefono == null || telefono.isBlank()){
            errores.put("telefono", "el telefono es requerido");
        }
        if(fechaNacimiento == null || fechaNacimiento.isBlank()){
            errores.put("fechaNacimiento","la fecha de Nacimiento es requerida!");
        }
        if (errores.isEmpty()){
            Chofer chofer = new Chofer();
            chofer.setId(0L);
            chofer.setNombre(nombre);
            chofer.setApPaterno(apPaterno);
            chofer.setApMaterno(apMaterno);
            chofer.setLicencia(licencia);
            chofer.setTelefono(telefono);
            chofer.setFechaNacimiento(fecha);
            chofer.setDisponibilidad(habilitar);
            service.guardar(chofer);
            resp.sendRedirect(req.getContextPath()+"/choferes/listar");
        }
        else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaChofer.jsp")
                    .forward(req, resp);

        }


    }
}
