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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class ProfesorDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.ProfesorDAO");

    Connection cn = conexion();

    public ProfesorDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public ArrayList<Profesor> listarTodo() {

        ArrayList<Profesor> listado = new ArrayList<>();

        String SSQL = "Select pr.idProfesor,pr.especialidadProfesor,pr.profesionProfesor,dap.idPersona,dap.cedPersona,"
                + " dap.nombrePersona,dap.apellido1, "
                + " dap.apellido2,dap.correoPersonal FROM Profesores pr, DatosPersona dap "
                + " where dap.idPersona = pr.idPersona ";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Profesor data = new Profesor();
                data.setIdProfesor(rs.getInt("idProfesor"));
                data.setEspecialidadProfesor(rs.getString("especialidadProfesor"));
                data.setProfesionProfesor(rs.getString("profesionProfesor"));
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

    public Profesor buscarPorIdProfesor(int idProfesor) {
        Profesor resultado = null;

        String SSQL = "Select idProfesor,especialidadProfesor,profesionProfesor,idPersona "
                + " from Profesores where idProfesor = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idProfesor);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();
                resultado.setIdProfesor(rs.getInt("idProfesor"));
                resultado.setEspecialidadProfesor(rs.getString("especialidadProfesor"));
                resultado.setProfesionProfesor(rs.getString("profesionProfesor"));
                resultado.setIdPersona(rs.getInt("idPersona"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar estudiante ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Profesor buscarPorCedula(int cedula) {
        Profesor resultado = null;

        String SSQL = "Select pr.idProfesor,pr.especialidadProfesor,pr.profesionProfesor,dap.idPersona,dap.cedPersona,dap.nombrePersona,dap.apellido1, "
                + " dap.apellido2,dap.correoPersonal FROM Profesores pr, DatosPersona dap "
                + "  where dap.idPersona = pr.idPersona and dap.cedPersona = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, cedula);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();
                resultado.setIdProfesor(rs.getInt("idProfesor"));
                resultado.setEspecialidadProfesor(rs.getString("especialidadProfesor"));
                resultado.setProfesionProfesor(rs.getString("profesionProfesor"));
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
            LOGGER.log(Level.SEVERE, "Excepcion al consultar profesor ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Profesor buscarPorCodCurso(int codCurso) {
        Profesor resultado = null;

        String SSQL = "Select pr.idProfesor,pr.especialidadProfesor,pr.profesionProfesor,dap.idPersona,dap.cedPersona,dap.nombrePersona,dap.apellido1, "
                + " dap.apellido2,dap.correoPersonal FROM Profesores pr, DatosPersona dap, ProfesorCurso prcu"
                + "  where dap.idPersona = pr.idPersona and pr.idProfesor=prcu.idProfesor and prcu.codCurso = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codCurso);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Profesor();
                resultado.setIdProfesor(rs.getInt("idProfesor"));
                resultado.setEspecialidadProfesor(rs.getString("especialidadProfesor"));
                resultado.setProfesionProfesor(rs.getString("profesionProfesor"));
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
            LOGGER.log(Level.SEVERE, "Excepcion al consultar profesor ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(String especialidadProfesor, String profesionProfesor, int idPersona) {

        try {
            String sql = "INSERT INTO Profesores (especialidadProfesor,profesionProfesor,idPersona) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, especialidadProfesor);
            statement.setString(2, profesionProfesor);
            statement.setInt(3, idPersona);

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

    public int actualizar(int idProfesor, String especialidadProfesor, String profesionProfesor, int idPersona) {

        try {
            String sql = "UPDATE Profesores set especialidadProfesor = ?, profesionProfesor = ?, idPersona = ? "
                    + " WHERE idProfesor = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, especialidadProfesor);
            statement.setString(2, profesionProfesor);
            statement.setInt(3, idPersona);
            statement.setInt(4, idProfesor);

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
