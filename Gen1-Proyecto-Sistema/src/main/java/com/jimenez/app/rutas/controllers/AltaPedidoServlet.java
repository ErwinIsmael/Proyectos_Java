package com.jimenez.app.rutas.controllers;

import com.jimenez.app.rutas.models.Pedido;
import com.jimenez.app.rutas.services.IService;
import com.jimenez.app.rutas.services.PedidosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/pedidos/alta")
public class AltaPedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lógica para cargar datos necesarios para el formulario, si es necesario
        // ...

        getServletContext().getRequestDispatcher("/altaPedido.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Pedido> service = new PedidosService(conn);

        String uniformeId = req.getParameter("uniformeId");
        String clienteId = req.getParameter("clienteId");
        String cantidad = req.getParameter("cantidad");
        String fechaSolicitud = req.getParameter("fechaSolicitud");
        String fechaEntrega = req.getParameter("fechaEntrega");
        String anticipo = req.getParameter("anticipo");
        String estatus = req.getParameter("estatus");
        String descripcion = req.getParameter("descripcion");
        String talla = req.getParameter("talla");

        Map<String, String> errores = new HashMap<>();
        // Validaciones...

        if (errores.isEmpty()) {
            Pedido pedido = new Pedido();
            pedido.setId(0L);
            pedido.setUniformeId(Long.valueOf(uniformeId));
            pedido.setClienteId(Long.valueOf(clienteId));
            pedido.setCantidad(Integer.valueOf(cantidad));
            pedido.setFechaSolicitud(LocalDate.parse(fechaSolicitud));
            pedido.setFechaEntrega(LocalDate.parse(fechaEntrega));
            pedido.setAnticipo(Float.valueOf(anticipo));
            pedido.setEstatus(Boolean.parseBoolean(estatus));
            pedido.setDescripcion(descripcion);
            pedido.setTalla(talla);

            // Guardar en la base de datos
            service.guardar(pedido);

            resp.sendRedirect(req.getContextPath() + "/pedidos/lista");
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaPedido.jsp").forward(req, resp);
        }
    }
}
