package com.jimenez.api.repositories;

import com.jimenez.api.models.Ruta;

import java.sql.*;
import java.util.List;

public class RutasRepository implements IRutasRepository {
    private Connection conn;
    public RutasRepository(Connection conn) { this.conn = conn;}

    @Override
    public Long guardarReturnId(Ruta ruta) throws SQLException {
        String sql = "";
        int executeUpdate;
        long resultado = -1L;
        sql = "INSERT INTO RUTAS (ID_RUTA, CAMION_ID, CHOFER_ID, DIRECCION_ORIGEN_ID, DIRECCION_DESTINO_ID," +
                "DISTANCIA, FECHA_SALIDA, FECHA_LLEGADA_ESTIMADA, FECHA_LLEGADA_REAL, A_TIEMPO)" +
                "VALUES" +
                "(SEQUENCE4.NEXTVAL, ?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement stmt =
                conn.prepareStatement(sql, new String[]{"ID_DIRECCION"})){
            stmt.setLong(1, ruta.getCamionId());
            stmt.setLong(2, ruta.getChoferId());
            stmt.setLong(3, ruta.getDireccionOrigenId());
            stmt.setLong(4, ruta.getDireccionDestinoId());
            stmt.setFloat(5, ruta.getDistancia());
            stmt.setDate(6, Date.
                    valueOf(ruta.getFechaSalida()));
            stmt.setDate(7,Date
                    .valueOf(ruta.getFechaLlegadaEstimada()));
            stmt.setDate(8, Date
                    .valueOf(ruta.getFechaLlegadaReal()));
            stmt.setInt(7, ruta.getaTiempo() ? 1 : 0);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                resultado = rs.getLong(1);
            }
        }
        return resultado;
    }
    @Override
    public List<Ruta> listar() throws SQLException {
        return null;
    }

    @Override
    public Ruta getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Ruta ruta) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }


}
