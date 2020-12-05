/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Curso;
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

public class CursoDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.CursoDAO");

    Connection cn = conexion();

    public CursoDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public int Insertar(int cod, String nomCurso, int duracion) {

        try {
            String sql = "INSERT INTO Curso (codCurso, nombreCurso, horasDuracionCurso) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);
            statement.setString(2, nomCurso);
            statement.setInt(3, duracion);

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

    public ArrayList<Curso> ListarTodo() {

        ArrayList<Curso> listado = new ArrayList<>();

        String SSQL = "Select codCurso, nombreCurso, horasDuracionCurso from Curso";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                c.setCodCurso(rs.getInt("codCurso"));
                c.setNombreCurso(rs.getString("nombreCurso"));
                c.setHoras(rs.getInt("horasDuracionCurso"));

                listado.add(c);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public ArrayList<Curso> ListarCursoProfesor() {

        ArrayList<Curso> listado = new ArrayList<>();

        String SSQL = "Select cu.codCurso, cu.nombreCurso, dapr.nombrePersona, dapr.apellido1, dapr.apellido2 "
                + " from Curso cu, ProfesorCurso prcu,Profesores pr,DatosPersona dapr "
                + " where cu.codCurso=prcu.codCurso and prcu.idProfesor=pr.idProfesor and pr.idPersona=dapr.idPersona ";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                Profesor p = new Profesor();
                c.setCodCurso(rs.getInt("codCurso"));
                c.setNombreCurso(rs.getString("nombreCurso"));

                p.setNombrePersona(rs.getString("nombrePersona"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));

                c.setProfesor(p);

                listado.add(c);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public Curso ListarCursoEstudiantes(int codCurso) {

        Curso c = new Curso();
        ArrayList<Estudiante> listadoEstudiantes = new ArrayList<Estudiante>();

        String SSQL = "select cu.codCurso, cu.nombreCurso, ma.fechaInicio, ma.fechaConclusion, es.idEstudiante,"
                + " es.carneEstudiante, da.idPersona, da.nombrePersona, da.apellido1, da.apellido2 "
                + " from Curso cu, Matricula ma, Estudiante es, DatosPersona da "
                + " where cu.codCurso=? and cu.codCurso=ma.codCurso and ma.idEstudiante=es.idEstudiante and es.idPersona=da.idPersona ";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codCurso);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                c.setCodCurso(rs.getInt("codCurso"));
                c.setNombreCurso(rs.getString("nombreCurso"));
                c.setFechaInicio(rs.getDate("fechaInicio"));
                c.setFechaFinal(rs.getDate("fechaConclusion"));

                Estudiante e = new Estudiante();
                e.setIdEstudiante(rs.getInt("idEstudiante"));
                e.setCarneEstudiante(rs.getString("carneEstudiante"));
                e.setIdPersona(rs.getInt("idPersona"));
                e.setNombrePersona(rs.getString("nombrePersona"));
                e.setApellido1(rs.getString("apellido1"));
                e.setApellido2(rs.getString("apellido2"));

                listadoEstudiantes.add(e);
            }

            c.setListadoEstudiantes(listadoEstudiantes);

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return c;
    }

    public Curso buscarCursoPorCod(int codCurso) {
        Curso c = null;

        String SSQL = "Select codCurso, nombreCurso, horasDuracionCurso "
                + "from Curso where codCurso = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codCurso);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                c = new Curso();
                c.setNombreCurso(rs.getString("nombreCurso"));
                c.setHoras(rs.getInt("horasDuracionCurso"));
                c.setCodCurso(codCurso);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return c;
    }

    public int actualizarCurso(int cod, String nomCurso, int duracion) {

        try {
            String sql = "UPDATE Curso set nombreCurso = ?, horasDuracionCurso = ? "
                    + "WHERE codCurso = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, nomCurso);
            statement.setInt(2, duracion);
            statement.setInt(3, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar curso ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminarCurso(int cod) {

        try {
            String sql = "DELETE FROM Curso WHERE codCurso = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar curso ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }

    public int AgregarProfesorCurso(int idProfesor, int codCurso, String periodo) {

        try {
            String sql = "INSERT INTO ProfesorCurso (idProfesor,codCurso,periodo) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, idProfesor);
            statement.setInt(2, codCurso);
            statement.setString(3, periodo);

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

    public Curso obtenerDatosCurso(int codCurso) {
        Curso c = null;

        String SSQL = "Select codCurso, nombreCurso, horasDuracionCurso "
                + "from Curso where codCurso = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codCurso);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                c = new Curso();
                c.setNombreCurso(rs.getString("nombreCurso"));
                c.setHoras(rs.getInt("horasDuracionCurso"));
                c.setCodCurso(codCurso);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar curso ::: {0}", ex.getLocalizedMessage());
        }
        return c;
    }

}
