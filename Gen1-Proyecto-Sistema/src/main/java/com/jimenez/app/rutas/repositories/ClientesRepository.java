package com.jimenez.app.rutas.repositories;

import com.jimenez.app.rutas.models.Cliente;

import java.sql.*;
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
        Cliente cliente =null;
        try (PreparedStatement stmt =
                conn.prepareStatement("SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    cliente = this.getCliente(rs);
                }
            }
        }
        return cliente;
    }

    @Override
    public void guardar(Cliente cliente) throws SQLException {
        String sql = "";
        if (cliente.getId() != null && cliente.getId() > 0){
            sql = "update clientes set nombre=?, ap_paterno=?, ap_materno=?, telefono=?, email=? where id_cliente=?";

        }else {
            sql = "insert into clientes (id_cliente, nombre, ap_paterno, ap_materno, telefono, email)" +
                    "values (SEQUENCE6.NEXTVAL, ?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if (cliente.getId() != null && cliente.getId() > 0){
                stmt.setString(1, cliente.getNombre());
                stmt.setString(2, cliente.getApPaterno());
                stmt.setString(3, cliente.getApMaterno());
                stmt.setString(4, cliente.getTelefono());
                stmt.setString(5, cliente.getEmail());
                stmt.setLong(6, cliente.getId());
            }else {
                stmt.setString(1, cliente.getNombre());
                stmt.setString(2, cliente.getApPaterno());
                stmt.setString(3, cliente.getApMaterno());
                stmt.setString(4, cliente.getTelefono());
                stmt.setString(5, cliente.getEmail());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from clientes where id_cliente=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    //mapear/transformar un renglon/fila/registro/row en un objeto de tipo chofer
    private Cliente getCliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setId(rs.getLong("ID_CLIENTE"));
        c.setNombre(rs.getString("NOMBRE"));
        c.setApPaterno(rs.getString("AP_PATERNO"));
        c.setApMaterno(rs.getString("AP_MATERNO"));
        c.setTelefono(rs.getString("TELEFONO"));
        c.setEmail(rs.getString("EMAIL"));
        return c;
    }
}
