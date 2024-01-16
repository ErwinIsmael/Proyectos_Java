package com.jimenez.api.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    //atributos

    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/xe";
    private static String username = "SYSTEM";
    private static String pasword = "1234";

    //metodos
    //METODO QUE ESTABLECE LA CONEXION AL SERVIDOR DE BD ORACLE
    public static Connection getInstance(){
        try {
            return DriverManager.getConnection(url, username, pasword);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
