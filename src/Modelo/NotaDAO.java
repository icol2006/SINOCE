/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Curso;
import Controlador.Estudiante;
import Controlador.Nota;
import Controlador.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class NotaDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.NotaDAO");

    Connection cn = conexion();

    public NotaDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public ArrayList<Nota> ListarTodo() {

        ArrayList<Nota> listado = new ArrayList<>();

        String SSQL = "Select idNota, idEstudiante, codCurso,calificacion from nota";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Nota n = new Nota();
                n.setIdNota(rs.getInt("idNota"));
                n.setIdEstudiante(rs.getInt("idEstudiante"));
                n.setCodCurso(rs.getInt("codCurso"));
                n.setCalificacion(rs.getInt("calificacion"));

                listado.add(n);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar nota ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public ArrayList<Nota> ListarNotasPorCurso(int codCurso) {

        ArrayList<Nota> listado = new ArrayList<>();

        String SSQL = "Select n.idNota, n.codCurso, n.calificacion, es.idEstudiante, es.carneEstudiante, "
                + " da.idPersona, da.nombrePersona,da.apellido1, da.apellido2 "
                + " from nota n, Curso cu, Estudiante es, DatosPersona da "
                + " where cu.codCurso=? and n.codCurso=cu.codCurso and n.idEstudiante=es.idEstudiante and es.idPersona=da.idPersona ";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codCurso);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Nota n = new Nota();
                Estudiante e = new Estudiante();

                n.setIdNota(rs.getInt("idNota"));
                n.setIdEstudiante(rs.getInt("idEstudiante"));
                n.setCodCurso(rs.getInt("codCurso"));
                n.setCalificacion(rs.getInt("calificacion"));

                e.setIdEstudiante(rs.getInt("idEstudiante"));
                e.setIdPersona(rs.getInt("idPersona"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));
                n.setEstudiante(e);

                listado.add(n);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar nota ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public Nota buscarPorId(int idNota) {
        Nota c = null;

        String SSQL = "Select idNota, idEstudiante, codCurso,calificacion from nota "
                + " where idNota = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idNota);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                c = new Nota();
                c.setIdNota(rs.getInt("idNota"));
                c.setIdNota(rs.getInt("idEstudiante"));
                c.setIdNota(rs.getInt("codCurso"));
                c.setIdNota(rs.getInt("calificacion"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return c;
    }

    public Nota BuscarPorIdEstudianteIdCurso(int idEstudiante, int codCurso) {
        Nota c = null;

        String SSQL = "Select idNota, idEstudiante, codCurso,calificacion from nota "
                + " where idEstudiante = ? and codCurso = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idEstudiante);
            pst.setInt(2, codCurso);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                c = new Nota();
                c.setIdNota(rs.getInt("idNota"));
                c.setIdEstudiante(rs.getInt("idEstudiante"));
                c.setCodCurso(rs.getInt("codCurso"));
                c.setCalificacion(rs.getInt("calificacion"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return c;
    }

    public int Insertar(int idEstudiante, int codCurso, int calificacion) {

        try {
            String sql = "INSERT INTO Nota (idEstudiante, codCurso, calificacion) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idEstudiante);
            statement.setInt(2, codCurso);
            statement.setInt(3, calificacion);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR 
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar nota ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }

    public int Actualizar(int idNota, int idEstudiante, int codCurso, int calificacion) {

        try {
            String sql = "UPDATE Nota set idEstudiante = ?, codCurso = ?, calificacion = ? "
                    + "WHERE idNota = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idEstudiante);
            statement.setInt(2, codCurso);
            statement.setInt(3, calificacion);
            statement.setInt(4, idNota);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR 
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar nota ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int Eliminar(int cod) {

        try {
            String sql = "DELETE FROM Nota WHERE idNota = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR 
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar nota ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }
}
