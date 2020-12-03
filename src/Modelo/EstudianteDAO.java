/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Estudiante;
import Controlador.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class EstudianteDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.EstudianteDAO");

    Connection cn = conexion();

    public EstudianteDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public Estudiante buscarPorCed(int cedPersona) {
        Estudiante resultado = null;

        String SSQL = "Select carneEstudiante,cedPersona "
                + "from Estudiante where cedPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, cedPersona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Estudiante();
                resultado.setCarneEstudiante(rs.getString("carneEstudiante"));
                resultado.setCedulaPersona(rs.getInt("cedPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(int cedPersona) {

        try {
            String sql = "INSERT INTO Estudiante (cedPersona) "
                    + "VALUES (?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedPersona);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar estudiante ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }
    
     public int actualizar(int cedPersona, int carneEstudiante) {

        try {
            String sql = "UPDATE Estudiante set  cedPersona = ? "
                    + "WHERE carneEstudiante = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedPersona);
            statement.setInt(2, carneEstudiante);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar estudiante ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminar(int cod) {

        try {
            String sql = "DELETE FROM Estudiante WHERE carneEstudiante = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar estudiante ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }

}
