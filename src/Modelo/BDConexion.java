package Modelo;

import java.sql.*;

public class BDConexion {

    public Connection conexion() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BDSINOCE", "sa", "123456");
        } catch (Exception e) {
            System.out.print("Error de conexión");
        }
        return conn;

    }
}


