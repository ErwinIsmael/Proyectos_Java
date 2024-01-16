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

@WebServlet("/clientes/alta")
public class AltaClientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaClientes.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Cliente> service =new ClientesService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "el nombre es requerido!");
        }
        if (apPaterno == null || apPaterno.isBlank()){
            errores.put("apPaterno","El apellido Paterno es requerido!");
        }
        if (apMaterno == null || apMaterno.isBlank()){
            errores.put("apMaterno","El apellido materno es equerido!");
        }
        if (telefono == null || telefono.isBlank()){
            errores.put("telefono","El telefono es requerido!");
        }
        if (email == null || email.isBlank()){
            errores.put("email", "El correo electronico es requerido!");
        }
        if (errores.isEmpty()){
            Cliente cliente =new Cliente();
            cliente.setId(0L);
            cliente.setNombre(nombre);
            cliente.setApPaterno(apPaterno);
            cliente.setApMaterno(apMaterno);
            cliente.setTelefono(telefono);
            cliente.setEmail(email);
            service.guardar(cliente);
            resp.sendRedirect(req.getContextPath()+"/clientes/listar");
        }
        else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaClientes.jsp")
                    .forward(req, resp);
        }
    }
}
