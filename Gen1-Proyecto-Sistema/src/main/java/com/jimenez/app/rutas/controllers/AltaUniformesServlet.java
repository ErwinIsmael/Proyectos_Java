package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Escuela;
import com.jimenez.app.rutas.models.Uniforme;
import com.jimenez.app.rutas.services.EscuelaService;
import com.jimenez.app.rutas.services.IService;
import com.jimenez.app.rutas.services.UniformesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/uniformes/alta")
public class AltaUniformesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Escuela> service = new EscuelaService(conn);
        req.setAttribute("escuelas", service.listar());

        getServletContext().getRequestDispatcher("/altaUniforme.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Uniforme> service = new UniformesService(conn);

        String uniformeId = req.getParameter("uniformeId");
        String escuelaId = req.getParameter("escuelaId");
        String tipoUniforme = req.getParameter("tipoUniforme");
        String descripcion = req.getParameter("descripcion");
        String tipoMaterial = req.getParameter("tipoMaterial");
        String color = req.getParameter("color");
        String precio = req.getParameter("precio");


        Map<String, String> errores = new HashMap<>();
        if (escuelaId == null || escuelaId.isBlank()){
            errores.put("escuelaId", "El nombre es requerido!");
        }
        if (tipoUniforme == null || tipoUniforme.isBlank()){
            errores.put("tipoUniforme", "El tipo de uniforme esrequerido!");
        }
        if (descripcion == null || descripcion.isBlank()){
            errores.put("descripcion", "La descripcion es requerida!");
        }
        if (tipoMaterial == null || tipoMaterial.isBlank()){
            errores.put("tipoMaterial","El tipo de material es requerido!");
        }
        if (color == null || color.isBlank()){
            errores.put("color","El color es requerido!");
        }
        if (precio == null || precio.isBlank()){
            errores.put("precio","El precio es requerido!");
        }
        if (errores.isEmpty()){
            Uniforme uniforme = new Uniforme();
            uniforme.setId(0L);
            uniforme.setEscuelaId(Long.valueOf(escuelaId));
            uniforme.setTipoUniforme(tipoUniforme);
            uniforme.setDescripcion(descripcion);
            uniforme.setTipoMaterial(tipoMaterial);
            uniforme.setColor(color);
            uniforme.setPrecio(Float.valueOf(precio));
            resp.sendRedirect(req.getContextPath()+"/uniformes/listar");
        }
        else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("altaUniforme.jsp")
                    .forward(req,resp);
        }
    }
    }

