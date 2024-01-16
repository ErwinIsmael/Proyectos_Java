package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Cliente;
import com.jimenez.app.rutas.services.ClientesService;
import com.jimenez.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/clientes/eliminar")
public class EliminarClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection)req.getAttribute("conn");
        IService<Cliente> service = new ClientesService(conn);
        long id;
        try {
            id =Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Cliente cliente =new Cliente();
        if (id > 0){
            Optional<Cliente> o = service.getById(id);
            if (o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/clientes/listar");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                        "No existe el cliente en la bse de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "Error el id es null, se debe enviar como parametro en la url");
        }
    }

}
