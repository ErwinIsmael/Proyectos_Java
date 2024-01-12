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
import java.util.List;

@WebServlet("/clientes/listar")
public class ListaClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperamos la conexion que provee el filtro
        Connection conn = (Connection) req.getAttribute("conn");
        //Declaramosun objeto de tipo servicio
        IService<Cliente> service = new ClientesService(conn);
        List<Cliente> clientes = service.listar();

        /*
        for(Cliente c: clientes){
            resp.getWriter().println("<h1>" + c.getId() + " -> "
                    + c.getNombre() + " -> " + c.getApPaterno() + "</h1>");
        }

         */

        req.setAttribute("clientes", clientes);
        getServletContext().getRequestDispatcher("/listaClientes.jsp").forward(req,resp);
    }
}
