/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Matricula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class MatriculaDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.MatriculaDAO");

    Connection cn = conexion();

    public MatriculaDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public Matricula buscarPorId(int idMatricula) {
        Matricula resultado = null;

        String SSQL = "Select idMatricula,periodoMatricula,codCurso,idEstudiante,idInstituto,fechaInicio,fechaConclusion "
                + "from Matricula where idMatricula = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idMatricula);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Matricula();
                resultado.setIdMatricula(rs.getInt("idMatricula"));
                resultado.setPeriodoMatricula(rs.getString("periodoMatricula"));
                resultado.setCodCurso(rs.getInt("codCurso"));
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setIdInstituto(rs.getInt("idInstituto"));
                resultado.setFechaInicio(rs.getDate("fechaInicio"));
                resultado.setFechaConclusion(rs.getDate("fechaConclusion"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar matricula ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Matricula buscarPorPerido_CodCurso_CarEstudiante_CodSede(String periodoMatricula, int codCurso,
            int idEstudiante, int idInstituto) {
        Matricula resultado = null;

        String SSQL = "Select idMatricula,periodoMatricula,codCurso,idEstudiante,idInstituto,fechaInicio,fechaConclusion "
                + " from Matricula where periodoMatricula = ? and codCurso = ? and idEstudiante = ? and idInstituto = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setString(1, periodoMatricula);
            pst.setInt(2, codCurso);
            pst.setInt(3, idEstudiante);
            pst.setInt(4, idInstituto);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Matricula();
                resultado.setIdMatricula(rs.getInt("idMatricula"));
                resultado.setPeriodoMatricula(rs.getString("periodoMatricula"));
                resultado.setCodCurso(rs.getInt("codCurso"));
                resultado.setIdEstudiante(rs.getInt("idEstudiante"));
                resultado.setIdInstituto(rs.getInt("idInstituto"));
                resultado.setFechaInicio(rs.getDate("fechaInicio"));
                resultado.setFechaConclusion(rs.getDate("fechaConclusion"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar matricula ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(String periodoMatricula, int codCurso, int idEstudiante, int idInstituto, Date fechaInicio, Date fechaConclusion) {

        try {
            String sql = "INSERT INTO Matricula (periodoMatricula,codCurso,idEstudiante,idInstituto,fechaInicio,fechaConclusion) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, periodoMatricula);
            statement.setInt(2, codCurso);
            statement.setInt(3, idEstudiante);
            statement.setInt(4, idInstituto);
            statement.setDate(5, fechaInicio);
            statement.setDate(6, fechaConclusion);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar matricula ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }

    public int actualizar(int idMatricula, String periodoMatricula, int codCurso, int idEstudiante, int idInstituto,
            Date fechaInicio, Date fechaConclusion) {

        try {
            String sql = "UPDATE Matricula set periodoMatricula = ?, codCurso = ?, idEstudiante = ?, idInstituto = ?, "
                    + "fechaInicio = ?, fechaConclusion = ?"
                    + "WHERE idMatricula = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, codCurso);
            statement.setInt(2, idEstudiante);
            statement.setInt(3, idInstituto);
            statement.setDate(4, fechaInicio);
            statement.setDate(5, fechaConclusion);
            statement.setString(6, periodoMatricula);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar matricula ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminar(int cod) {

        try {
            String sql = "DELETE FROM Matricula WHERE idMatricula = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar matricula ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }
}
