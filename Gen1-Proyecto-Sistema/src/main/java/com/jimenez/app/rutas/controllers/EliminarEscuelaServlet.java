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
import java.util.Optional;

@WebServlet("/escuelas/eliminar")
public class EliminarEscuelaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Escuela> service = new EscuelaService(conn);
        long id;
        try {
            id=Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Escuela escuela = new Escuela();
        if (id > 0){
            Optional<Escuela> o = service.getById(id);
            if (o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/escuelas/listar");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                        "No exisre la escuela en la base de dtaos");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "Error el id es null, se debe enviar como parametro en la url");
        }

    }
}
