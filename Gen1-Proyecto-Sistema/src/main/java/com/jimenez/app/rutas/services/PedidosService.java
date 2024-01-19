

package com.jimenez.app.rutas.services;

import com.jimenez.app.rutas.models.Pedido;
import com.jimenez.app.rutas.repositories.IRepository;
import com.jimenez.app.rutas.repositories.PedidosRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PedidosService implements IService<Pedido> {

    private IRepository<Pedido> pedidosRepo;

    public PedidosService(Connection connection) {
        pedidosRepo = new PedidosRepository(connection);
    }

    @Override
    public List<Pedido> listar() {
        try {
            return pedidosRepo.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Pedido> getById(Long id) {
        try {
            return Optional.ofNullable(pedidosRepo.getById(id));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Pedido pedido) {
        try {
            pedidosRepo.guardar(pedido);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            pedidosRepo.eliminar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}

