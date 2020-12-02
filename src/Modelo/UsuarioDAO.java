package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO extends BDConexion {
//DAO=Data Access Object

    Connection cn = conexion();

    public boolean ConexionUsuario(String usuario, String clave) throws SQLException {
        boolean resultado = false;
        String SSQL = "SELECT * FROM usuarios WHERE usuario='" + usuario + "' AND contrasenia=('" + clave + "')";

        try (Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SSQL)) {

            resultado = rs.next();

        } catch (SQLException e) {
           // JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error de ingreso)", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;

    }
    
    
}
