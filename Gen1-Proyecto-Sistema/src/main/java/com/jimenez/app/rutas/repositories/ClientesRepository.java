package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientesRepository implements IRepository<Cliente>{

    //atributos

    private Connection conn;//importardejava.sql

    public ClientesRepository(Connection conn){ this.conn = conn; }

    @Override
    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES")){
            while (rs.next()){
                Cliente c = this.getCliente(rs);
                clientes.add(c);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return clientes;
    }

    @Override
    public Cliente getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Cliente cliente) throws SQLException {

    }

    @Override
    public void elimina(Long id) throws SQLException {

    }

    //mapear/transformar un renglon/fila/registro/row en un objeto de tipo chofer
    private Cliente getCliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setId(rs.getLong("ID_CLIENTE"));
        c.setNombre(rs.getString("NOMBRE"));
        c.setApPaterno(rs.getString("AP_PATERNO"));
        c.setApMaterno(rs.getString("AP_MATERNO"));
        c.setTelefono(rs.getString("TELEFONO"));
        return c;
    }
}
