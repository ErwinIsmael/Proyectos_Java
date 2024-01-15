package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Camion;
import com.jimenez.app.rutas.services.CamionesService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamionesRepository implements IRepository<Camion>{
    //atributos
    private Connection conn; //se importo de java.sql
    //constructor

    public CamionesRepository(Connection conn) {
        this.conn = conn;
    }



    @Override
    public List<Camion> listar() throws SQLException {
        List<Camion> camiones = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CAMIONES")){
            while (rs.next()){
                Camion c = this.getCamion(rs);
                camiones.add(c);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return camiones;
    }

    @Override
    public Camion getById(Long id) throws SQLException {
        Camion camion = null;
        try (PreparedStatement stmt =
                conn.prepareStatement("SELECT * FROM CAMIONES WHERE ID_CAMION = ?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    camion = this.getCamion(rs);
                }
            }
        }
        return camion;
    }

    @Override
    public void guardar(Camion camion) throws SQLException {
        String sql = "";
        if (camion.getId() != null && camion.getId() > 0){
            sql = "update camiones set matricula=?, tipo_camion=?," +
                    "modelo=?, marca=?, capacidad=?, kilometraje=?, disponibilidad=?" +
                    "where id_camion=?";
        }else {
            sql = "insert into camiones (id_camion,matricula,tipo_camion," +
                    "modelo,marca,capacidad,kilometraje,disponibilidad)" +
                    "values (SEQUENCE2.NEXTVAL,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if(camion.getId() != null && camion.getId() > 0){
                stmt.setString(1, camion.getMatricula());
                stmt.setString(2, camion.getTipoCamion());
                stmt.setInt(3, camion.getModelo());
                stmt.setString(4, camion.getMarca());
                stmt.setLong(5, camion.getCapacidad());
                stmt.setDouble(6,camion.getKilometraje());
                stmt.setInt(7,camion.getDisponibilidad() ? 1 : 0);
                stmt.setLong(8, camion.getId());
            }else {
                stmt.setString(1, camion.getMatricula());
                stmt.setString(2, camion.getTipoCamion());
                stmt.setInt(3, camion.getModelo());
                stmt.setString(4, camion.getMarca());
                stmt.setLong(5, camion.getCapacidad());
                stmt.setDouble(6,camion.getKilometraje());
                stmt.setInt(7,camion.getDisponibilidad() ? 1 : 0);
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from camiones where id_camion=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
    //mapear / transformar un regristro de la base de datos a un objeto de tipo camion

    private Camion getCamion(ResultSet rs) throws SQLException{
        Camion c = new Camion();
        c.setId(rs.getLong("ID_CAMION"));
        c.setMatricula(rs.getString("MATRICULA"));
        c.setTipoCamion(rs.getString("TIPO_CAMION"));
        c.setModelo(rs.getInt("MODELO"));
        c.setMarca(rs.getString("MARCA"));
        c.setCapacidad(rs.getLong("CAPACIDAD"));
        c.setKilometraje(rs.getDouble("KILOMETRAJE"));
        c.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));
        return c;
    }



}
