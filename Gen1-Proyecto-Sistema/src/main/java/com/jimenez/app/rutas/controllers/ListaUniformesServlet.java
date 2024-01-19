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
import java.util.List;

@WebServlet("/uniformes/lista")
public class ListaUniformesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Uniforme> service = new UniformesService(conn);
        List<Uniforme> uniformes = service.listar();

        req.setAttribute("uniformes",uniformes);
        getServletContext().getRequestDispatcher("/listaUniformes.jsp").forward(req,resp);
    }
}
