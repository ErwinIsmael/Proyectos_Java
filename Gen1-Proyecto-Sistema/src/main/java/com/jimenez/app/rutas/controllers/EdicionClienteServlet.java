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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/clientes/editar")
public class EdicionClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Cliente> service = new ClientesService(conn);
        long id;
        try {
            id=Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Cliente cliente = new Cliente();
        if (id > 0){
            Optional<Cliente> o = service.getById(id);
            if (o.isPresent()){
                cliente = o.get();
                req.setAttribute("cliente", cliente);
                getServletContext().getRequestDispatcher("/edicionCliente.jsp")
                        .forward(req, resp);
            }
            else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                        "No existe el clinente en la base de datoas");
            }
        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "Error el id es null, se debe enviar como parametro en la url!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Cliente> service = new ClientesService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "El nombre es requerido!");
        }
        if (apPaterno == null || apPaterno.isBlank()){
            errores.put("apPaterno", "el apellido paterno es requerido!");
        }
        if (apMaterno == null || apMaterno.isBlank()){
            errores.put("apMaterno", "el apellido materno es requerido!");
        }
        if (telefono == null || telefono.isBlank()){
            errores.put("telefono", "El telefono es requerido!");
        }
        if (email == null || email.isBlank()){
            errores.put("email","El email es requerido!");
        }

        long id;
        id = Long.parseLong(req.getParameter("id"));
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApPaterno(apPaterno);
        cliente.setApMaterno(apMaterno);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        if (errores.isEmpty()){
            service.guardar(cliente);
            resp.sendRedirect(req.getContextPath() + "/clientes/listar");
        }
        else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/edicionCliente.jsp")
                    .forward(req,resp);
        }
    }
}



























