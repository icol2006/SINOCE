/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Persona;
import Controlador.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class PersonaDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.PersonaDAO");

    Connection cn = conexion();

    public PersonaDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public Persona buscarPorIdPersona(int idPersona) {
        Profesor resultado = null;

        String SSQL = "Select idPersona,cedPersona,nombrePersona,apellido1,apellido2 ,correoPersonal "
                + "from DatosPersona where idPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idPersona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();
                resultado.setIdPersona(rs.getInt("idPersona"));
                resultado.setCedulaPersona(rs.getInt("cedPersona"));
                resultado.setNombrePersona(rs.getString("nombrePersona"));
                resultado.setApellido1(rs.getString("apellido1"));
                resultado.setApellido2(rs.getString("apellido2"));
                resultado.setApellido2(rs.getString("correoPersonal"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar persona ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Persona buscarPorCed(int cedPersona) {
        Profesor resultado = null;

        String SSQL = "Select idPersona,cedPersona,nombrePersona,apellido1,apellido2 ,correoPersonal "
                + "from DatosPersona where cedPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, cedPersona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();
                resultado.setIdPersona(rs.getInt("idPersona"));
                resultado.setCedulaPersona(rs.getInt("cedPersona"));
                resultado.setNombrePersona(rs.getString("nombrePersona"));
                resultado.setApellido1(rs.getString("apellido1"));
                resultado.setApellido2(rs.getString("apellido2"));
                resultado.setApellido2(rs.getString("correoPersonal"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar persona ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(int cedPersona, String nombrePersona, String apellido1, String apellido2, String correoPersonal) {

        try {
            String sql = "INSERT INTO DatosPersona (cedPersona,nombrePersona,apellido1,apellido2,correoPersonal) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedPersona);
            statement.setString(2, nombrePersona);
            statement.setString(3, apellido1);
            statement.setString(4, apellido2);
            statement.setString(5, correoPersonal);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar persona ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }

    public int actualizar(int idPersona, int cedPersona, String nombrePersona, String apellido1, String apellido2, String correoPersonal) {

        try {
            String sql = "UPDATE DatosPersona set cedPersona = ?, nombrePersona = ?, apellido1 = ?, apellido2 = ?, correoPersonal = ? "
                    + " WHERE idPersona = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedPersona);
            statement.setString(2, nombrePersona);
            statement.setString(3, apellido1);
            statement.setString(4, apellido2);
            statement.setString(5, correoPersonal);
            statement.setInt(6, idPersona);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar oersona ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminar(int id) {

        try {
            String sql = "DELETE FROM DatosPersona WHERE idPersona = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, id);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar persona ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }
}
