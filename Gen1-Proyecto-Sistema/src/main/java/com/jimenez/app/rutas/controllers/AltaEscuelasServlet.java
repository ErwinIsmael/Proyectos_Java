package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Escuela;
import com.jimenez.app.rutas.services.EscuelaService;
import com.jimenez.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/escuelas/alta")
public class AltaEscuelasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaEscuelas.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Escuela> service = new EscuelaService(conn);


        String nombre = req.getParameter("nombre");
        String escudo = req.getParameter("escudo");
        String direccion = req.getParameter("direccion");
        String cct =  req.getParameter("cct");
        String nivel = req.getParameter("nivel");

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre","El nombre es requerido!");
        }
        if (escudo == null || escudo.isBlank() ){
            errores.put("escudo","El escudo es requerido!");
        }
        if (direccion == null | direccion.isBlank()){
            errores.put("direccion","La direccion es requerida!");
        }
        if (cct == null || cct.isBlank()){
            errores.put("cct","El Centro de Trabajo de la escuela es requerida!");
        }
        if (nivel == null || nivel.isBlank()){
            errores.put("nivel","El nivel academico de la institucion es requerida!");
        }

        if(errores.isEmpty()){
            Escuela escuela = new Escuela();
            escuela.setId(0L);
            escuela.setNombre(nombre);
            escuela.setEscudo(escudo);
            escuela.setDireccion(direccion);
            escuela.setCCT(cct);
            escuela.setNivel(nivel);
            service.guardar(escuela);
            resp.sendRedirect(req.getContextPath()+"/escuelas/listar");
        }
        else {
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/altaEscuelas.jsp")
                    .forward(req, resp);
        }




    }

}

