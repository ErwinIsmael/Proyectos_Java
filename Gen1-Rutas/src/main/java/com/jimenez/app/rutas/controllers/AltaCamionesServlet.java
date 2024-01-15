package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Camion;
import com.jimenez.app.rutas.models.enums.Marcas;
import com.jimenez.app.rutas.services.CamionesService;
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

@WebServlet("/camiones/alta")
public class AltaCamionesServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaCamion.jsp")
                .forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Camion> service = new CamionesService(conn);

        String matricula = req.getParameter("matricula");
        String tipoCamion = req.getParameter("tipoCamion");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String capacidad = req.getParameter("capacidad");
        String kilometraje = req.getParameter("kilometraje");

        String checkbox[];
        checkbox = req.getParameterValues("disponibilidad");
        Boolean habilitar;
        if (checkbox != null){
            habilitar = true;
        }else {
            habilitar = false;
        }
        Map<String, String> errores = new HashMap<>();

        if (matricula == null || matricula.isBlank()){
            errores.put("matricula","la matricula es requerida");
        }
        if (tipoCamion == null || tipoCamion.isBlank()){
            errores.put("tipoCamion","El tipo camion es requerido");
        }
        if (modelo == null || modelo.isBlank()){
            errores.put("modelo","el modelo es requerido");
        }
        if (marca == null || marca.isBlank()){
            errores.put("marca","La marca es requerida");
        }
        if (capacidad == null || capacidad.isBlank()){
            errores.put("capacidad","La capacidad es requerida");
        }
        if (kilometraje == null || kilometraje.isBlank()){
            errores.put("kilometraje","El kilometraje es requerido");
        }
        if (errores.isEmpty()){
            Camion camion = new Camion();
            camion.setId(0L);
            camion.setMatricula(matricula);
            camion.setTipoCamion(tipoCamion);
            camion.setModelo(Integer.valueOf(modelo));
            camion.setMarca(marca);
            camion.setCapacidad(Long.valueOf(capacidad));
            camion.setKilometraje(Double.valueOf(kilometraje));
            camion.setDisponibilidad(habilitar);

            service.guardar(camion);
            resp.sendRedirect(req.getContextPath()+"/camiones/listar");
        }
        else {

            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaCamion.jsp")
                    .forward(req,resp);
        }
    }
}
