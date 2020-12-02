package Controlador;

import Modelo.UsuarioDAO;
import Presentacion.Menu;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {

    private String nombreUsuario;
    private String clave;

    public Usuario() {
        nombreUsuario = "";
        clave = "";
    }

    public boolean validaUsuario(String usuario, String clave) throws SQLException {

        boolean resultado = false;
        UsuarioDAO val = new UsuarioDAO();
        val.ConexionUsuario(usuario, clave);

        if (val.ConexionUsuario(usuario, clave)) {

            resultado = true;
            JOptionPane.showMessageDialog(null, "Bienvenido(a)\n Has ingresado "
                    + "satisfactoriamente al sistema", "Inicio de sesión",
                    JOptionPane.INFORMATION_MESSAGE);
            Menu menu = new Menu();
            menu.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);

        }
        return resultado;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return clave;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.clave = password;
    }

}
