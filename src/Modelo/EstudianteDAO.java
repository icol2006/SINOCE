/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Estudiante;
import Controlador.Instituto;
import Controlador.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class EstudianteDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.EstudianteDAO");

    Connection cn = conexion();

    public EstudianteDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public ArrayList<Estudiante> ListarTodo() {

        ArrayList<Estudiante> listado = new ArrayList<>();

        String SSQL = "Select es.idEstudiante,es.carneEstudiante,dap.idPersona,dap.cedPersona,dap.nombrePersona,dap.apellido1,"
                + "dap.apellido2,dap.correoPersonal FROM Estudiante es, DatosPersona dap where es.idPersona=dap.idPersona";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Estudiante data = new Estudiante();
                data.setIdEstudiante(rs.getInt("idEstudiante"));
                data.setCarneEstudiante(rs.getString("carneEstudiante"));
                data.setIdPersona(rs.getInt("idPersona"));
                data.setCedulaPersona(rs.getInt("cedPersona"));
                data.setNombrePersona(rs.getString("nombrePersona"));
                data.setApellido1(rs.getString("apellido1"));
                data.setApellido2(rs.getString("apellido2"));
                data.setCorreoElectronico(rs.getString("correoPersonal"));

                listado.add(data);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar instituto ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public Estudiante buscarPorIdEstudiante(int idEstudiante) {
        Estudiante resultado = null;

        String SSQL = "Select idEstudiante,carneEstudiante,idPersona "
                + " from Estudiante where idEstudiante = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idEstudiante);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Estudiante();
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setCarneEstudiante(rs.getString("carneEstudiante"));
                resultado.setIdPersona(rs.getInt("idPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Estudiante buscarPorCedula(int cedula) {
        Estudiante resultado = null;

        String SSQL = "Select es.idEstudiante,es.carneEstudiante,dap.idPersona,dap.cedPersona,dap.nombrePersona,dap.apellido1, "
                + " dap.apellido2,dap.correoPersonal FROM Estudiante es, DatosPersona dap "
                + "  where dap.cedPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, cedula);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Estudiante();
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setCarneEstudiante(rs.getString("carneEstudiante"));
                resultado.setIdPersona(rs.getInt("idPersona"));
                resultado.setCedulaPersona(rs.getInt("cedPersona"));
                resultado.setNombrePersona(rs.getString("nombrePersona"));
                resultado.setApellido1(rs.getString("apellido1"));
                resultado.setApellido2(rs.getString("apellido2"));
                resultado.setCorreoElectronico(rs.getString("correoPersonal"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Estudiante buscarPorIdPersona(int idPersona) {
        Estudiante resultado = null;

        String SSQL = "Select idEstudiante,carneEstudiante,idPersona "
                + " from Estudiante where idPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idPersona);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Estudiante();
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setCarneEstudiante(rs.getString("carneEstudiante"));
                resultado.setIdPersona(rs.getInt("idPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Estudiante buscarPorCarnet(String carne) {
        Estudiante resultado = null;

        String SSQL = "Select idEstudiante,carneEstudiante,idPersona "
                + " from Estudiante where carneEstudiante = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setString(1, carne);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Estudiante();
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setCarneEstudiante(rs.getString("carneEstudiante"));
                resultado.setIdPersona(rs.getInt("idPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(int idPersona, String carneEstudiante) {

        try {
            String sql = "INSERT INTO Estudiante (idPersona,carneEstudiante) "
                    + "VALUES (?,?);";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idPersona);
            statement.setString(2, carneEstudiante);

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

    public int actualizar(int idEstudiante, int idPersona, String carneEstudiante) {

        try {
            String sql = "UPDATE Estudiante set  idPersona = ?,carneEstudiante = ? "
                    + "WHERE idEstudiante = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idPersona);
            statement.setString(2, carneEstudiante);
            statement.setInt(3, idEstudiante);

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

    public int eliminar(int id) {

        try {
            String sql = "DELETE FROM Estudiante WHERE idEstudiante = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, id);

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
