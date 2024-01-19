package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Uniforme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniformesRepository implements IRepository<Uniforme> {
    private Connection conn;

    public UniformesRepository(Connection conn) { this.conn = conn; }

    @Override
    public List<Uniforme> listar() throws SQLException {
        List<Uniforme> uniformes = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM UNIFORMES")){
            while (rs.next()){
                Uniforme u = this.getUniforme(rs);
                uniformes.add(u);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return uniformes;
    }

    @Override
    public Uniforme getById(Long id) throws SQLException {
        Uniforme uniforme = null;
        try (PreparedStatement stmt =
                     conn.prepareStatement("")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    uniforme = this.getUniforme(rs);
                }
            }
        }
        return uniforme;
    }

    @Override
    public void guardar(Uniforme uniforme) throws SQLException {
        String sql = "";
        if (uniforme.getId() != null && uniforme.getId() > 0){
            sql = "UPDATE UNIFORMES set ESCUELA_ID=?, TIPO_UNIFORME=?, DESCRIPCION=?, " +
                    "TIPO_MATERIAL=?, COLOR=?, PRECIO=?";
        } else {
            sql = "INSERT INTO UNIFORMES (ID_UNIFORME, ESCUELA_ID, TIPO_UNIFORME, DESCRIPCION, TIPO_MATERIAL, COLOR, PRECIO)" +
                    "VALUES" +
                    "(SEQUENCE8.NEXTVAL, ?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if (uniforme.getId() != null && uniforme.getId() > 0){
                stmt.setLong(1, uniforme.getEscuelaId());
                stmt.setString(2, uniforme.getTipoUniforme());
                stmt.setString(3, uniforme.getDescripcion());
                stmt.setString(4, uniforme.getTipoMaterial());
                stmt.setString(5, uniforme.getColor());
                stmt.setFloat(6, uniforme.getPrecio());
                stmt.setLong(7,uniforme.getId());
            }else {
                stmt.setLong(1, uniforme.getEscuelaId());
                stmt.setString(2, uniforme.getTipoUniforme());
                stmt.setString(3, uniforme.getDescripcion());
                stmt.setString(4, uniforme.getTipoMaterial());
                stmt.setString(5, uniforme.getColor());
                stmt.setFloat(6, uniforme.getPrecio());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from uniformes where id_uniforme=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Uniforme getUniforme(ResultSet rs) throws SQLException{
        Uniforme a = new Uniforme();
        a.setId(rs.getLong("ID_UNIFORME"));
        a.setEscuelaId(rs.getLong("ESCUELA_ID"));
        a.setTipoUniforme(rs.getString("TIPO_UNIFORME"));
        a.setDescripcion(rs.getString("DESCRIPCION"));;
        a.setTipoMaterial(rs.getString("TIPO_MATERIAL"));
        a.setColor(rs.getString("COLOR"));
        a.setPrecio(rs.getFloat("PRECIO"));
        return a;
    }


}
