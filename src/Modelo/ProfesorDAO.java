/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class ProfesorDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.ProfesorDAO");

    Connection cn = conexion();

    public ProfesorDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public Profesor buscarPorCed(int cedPersona) {
        Profesor resultado = null;

        String SSQL = "Select codProfesor,especialidadProfesor,profesionProfesor,cedPersona "
                + "from Profesores where cedPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, cedPersona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();                
                resultado.setCodProfesor(rs.getInt("codProfesor"));
                resultado.setEspecialidadProfesor(rs.getString("especialidadProfesor"));
                resultado.setProfesionProfesor(rs.getString("profesionProfesor"));
                resultado.setCedulaPersona(rs.getInt("cedPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar profesor ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(String especialidadProfesor, String profesionProfesor, int cedPersona) {

        try {
            String sql = "INSERT INTO Profesores (especialidadProfesor,profesionProfesor,cedPersona) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, especialidadProfesor);
            statement.setString(2, profesionProfesor);
            statement.setInt(3, cedPersona);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar curso ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }

    public int actualizar(String especialidadProfesor, String profesionProfesor, int cedPersona, int codProfesor) {

        try {
            String sql = "UPDATE Profesores set especialidadProfesor = ?, profesionProfesor = ?, cedPersona = ? "
                    + "WHERE codProfesor = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, especialidadProfesor);
            statement.setString(2, profesionProfesor);
            statement.setInt(3, cedPersona);
            statement.setInt(4, codProfesor);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar proefesor ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminar(int cod) {

        try {
            String sql = "DELETE FROM Profesores WHERE codProfesor = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar profesor ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }

}
