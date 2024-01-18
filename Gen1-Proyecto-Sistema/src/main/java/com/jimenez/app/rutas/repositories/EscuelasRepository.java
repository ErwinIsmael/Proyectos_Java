package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Escuela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EscuelasRepository implements IRepository<Escuela>{

    private Connection conn;
    public EscuelasRepository(Connection conn){ this.conn = conn; }

    @Override
    public List<Escuela> listar() throws SQLException {
        List<Escuela> escuelas = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ESCUELAS")){
            while (rs.next()){
                Escuela e = this.getEscuela(rs);
                escuelas.add(e);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return escuelas;
    }

    @Override
    public Escuela getById(Long id) throws SQLException {
        Escuela escuela = null;
        try (PreparedStatement stmt =
                conn.prepareStatement("SELECT * FROM ESCUELAS WHERE ID_ESCUELA = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    escuela = this.getEscuela(rs);
                }
            }
        }
        return escuela;
    }

    @Override
    public void guardar(Escuela escuela) throws SQLException {
        String sql = "";
        if (escuela.getId() != null && escuela.getId() > 0){
            sql="update escuelas set nombre=?, escudo=?, direccion=?, cct=?, nivel=?";

        }else{
            sql = "INSERT INTO ESCUELAS (ID_ESCUELA, NOMBRE, ESCUDO, DIRECCION, CCT, NIVEL)" +
                    "VALUES" +
                    "(SEQUENCE7.NEXTVAL, ?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if (escuela.getId() != null && escuela.getId() > 0){
                stmt.setString(1, escuela.getNombre());
                stmt.setString(2, escuela.getEscudo());
                stmt.setString(3, escuela.getDireccion());
                stmt.setString(4, escuela.getCCT());
                stmt.setString(5, escuela.getNivel());
                stmt.setLong(6, escuela.getId());
            }else {
                stmt.setString(1, escuela.getNombre());
                stmt.setString(2, escuela.getEscudo());
                stmt.setString(3, escuela.getDireccion());
                stmt.setString(4, escuela.getCCT());
                stmt.setString(5, escuela.getNivel());
            }
            stmt.executeUpdate();

        }

    }
    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from escuelas where id_escuela=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

    }



    private Escuela getEscuela(ResultSet rs) throws SQLException{
        Escuela e = new Escuela();
        e.setId(rs.getLong("ID_ESCUELA"));
        e.setNombre((rs.getString("NOMBRE")));
        e.setEscudo(rs.getString("ESCUDO"));
        e.setCCT(rs.getString("CCT"));
        e.setDireccion(rs.getString("DIRECCION"));
        e.setNivel(rs.getString("NIVEL"));
        return e;
    }
}
