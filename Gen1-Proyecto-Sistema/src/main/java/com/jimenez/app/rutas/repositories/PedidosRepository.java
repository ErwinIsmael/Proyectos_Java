

package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Pedido;

import java.sql.*;
        import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidosRepository implements IRepository<Pedido> {
    private Connection conn;

    public PedidosRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM PEDIDOS")) {
            while (rs.next()) {
                Pedido pedido = getPedido(rs);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }

    @Override
    public Pedido getById(Long id) throws SQLException {
        Pedido pedido = null;
        try (PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM PEDIDOS WHERE ID_PEDIDO = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pedido = getPedido(rs);
                }
            }
        }
        return pedido;
    }

    @Override
    public void guardar(Pedido pedido) throws SQLException {
        String sql;
        if (pedido.getId() != null && pedido.getId() > 0) {
            sql = "UPDATE PEDIDOS SET UNIFORME_ID=?, CLIENTE_ID=?, CANTIDAD=?, FECHA_SOLICITUD=?, FECHA_ENTREGA=?, " +
                    "ANTICIPO=?, ESTATUS=?, DESCRIPCION=?, TALLA=? WHERE ID_PEDIDO=?";
        } else {
            sql = "INSERT INTO PEDIDOS (ID_PEDIDO, UNIFORME_ID, CLIENTE_ID, CANTIDAD, FECHA_SOLICITUD, FECHA_ENTREGA, " +
                    "ANTICIPO, ESTATUS, DESCRIPCION, TALLA) VALUES " +
                    "(SEQUENCE9.NEXTVAL, ?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, pedido.getUniformeId());
            stmt.setLong(2, pedido.getClienteId());
            stmt.setInt(3, pedido.getCantidad());
            stmt.setDate(4, Date.valueOf(pedido.getFechaSolicitud()));
            stmt.setDate(5, Date.valueOf(pedido.getFechaEntrega()));
            stmt.setFloat(6, pedido.getAnticipo());
            stmt.setBoolean(7, pedido.getEstatus());
            stmt.setString(8, pedido.getDescripcion());
            stmt.setString(9, pedido.getTalla());

            if (pedido.getId() != null && pedido.getId() > 0) {
                stmt.setLong(10, pedido.getId());
            }

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM PEDIDOS WHERE ID_PEDIDO=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Pedido getPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setId(rs.getLong("ID_PEDIDO"));
        pedido.setUniformeId(rs.getLong("UNIFORME_ID"));
        pedido.setClienteId(rs.getLong("CLIENTE_ID"));
        pedido.setCantidad(rs.getInt("CANTIDAD"));
        pedido.setFechaSolicitud(rs.getDate("FECHA_SOLICITUD").toLocalDate());
        pedido.setFechaEntrega(rs.getDate("FECHA_ENTREGA").toLocalDate());
        pedido.setAnticipo(rs.getFloat("ANTICIPO"));
        pedido.setEstatus(rs.getBoolean("ESTATUS"));
        pedido.setDescripcion(rs.getString("DESCRIPCION"));
        pedido.setTalla(rs.getString("TALLA"));
        return pedido;
    }
}
