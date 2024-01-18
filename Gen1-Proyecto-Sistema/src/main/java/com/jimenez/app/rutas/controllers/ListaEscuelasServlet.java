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
import java.util.List;

@WebServlet("/escuelas/listar")
public class ListaEscuelasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Escuela> service = new EscuelaService(conn);
        List<Escuela> escuelas = service.listar();

        req.setAttribute("escuelas",escuelas);
        getServletContext().getRequestDispatcher("/listaEscuelas.jsp").forward(req,resp);
    }
}
