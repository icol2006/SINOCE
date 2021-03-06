/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Instituto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

public class InstitutoDAO extends BDConexion {

    private final static Logger LOGGER = Logger.getLogger("Modelo.InstitutoDAO");

    Connection cn = conexion();

    public InstitutoDAO() {
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public Instituto buscarPorId(int idInstituto) {
        Instituto resultado = null;

        String SSQL = "Select idInstituto,cedJuridica,codSede,nombreInstituto,ubicacionInstituto "
                + "from Instituto where idInstituto = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, idInstituto);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Instituto();
                resultado.setIdInstituto(rs.getInt("idInstituto"));
                resultado.setCedJuridica(rs.getInt("cedJuridica"));
                resultado.setCodSede(rs.getInt("codSede"));
                resultado.setNombreInstituto(rs.getString("nombreInstituto"));
                resultado.setUbicacionInstituto(rs.getString("ubicacionInstituto"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar instituto ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Instituto buscarPorCodSede(int codSede) {
        Instituto resultado = null;

        String SSQL = "Select idInstituto,cedJuridica,codSede,nombreInstituto,ubicacionInstituto "
                + "from Instituto where codSede = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setInt(1, codSede);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Instituto();
                resultado.setIdInstituto(rs.getInt("idInstituto"));
                resultado.setCedJuridica(rs.getInt("cedJuridica"));
                resultado.setCodSede(rs.getInt("codSede"));
                resultado.setNombreInstituto(rs.getString("nombreInstituto"));
                resultado.setUbicacionInstituto(rs.getString("ubicacionInstituto"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar instituto ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public Instituto buscarPorNombreInstituto(String nombreInstituto) {
        Instituto resultado = null;

        String SSQL = "Select idInstituto,cedJuridica,codSede,nombreInstituto,ubicacionInstituto "
                + "from Instituto where nombreInstituto = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);
            pst.setString(1, nombreInstituto);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = new Instituto();
                resultado.setIdInstituto(rs.getInt("idInstituto"));
                resultado.setCedJuridica(rs.getInt("cedJuridica"));
                resultado.setCodSede(rs.getInt("codSede"));
                resultado.setNombreInstituto(rs.getString("nombreInstituto"));
                resultado.setUbicacionInstituto(rs.getString("ubicacionInstituto"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar instituto ::: {0}", ex.getLocalizedMessage());
        }
        return resultado;
    }

    public int insertar(int cedJuridica, int codSede, String nombreInstituto, String ubicacionInstituto) {

        try {
            String sql = "INSERT INTO Instituto (cedJuridica,codSede,nombreInstituto,ubicacionInstituto) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedJuridica);
            statement.setInt(2, codSede);
            statement.setString(3, nombreInstituto);
            statement.setString(4, ubicacionInstituto);

            int filasInsertadas = statement.executeUpdate();

            statement.close();

            if (filasInsertadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al guardar instituto ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_GUARDAR;
    }

    public ArrayList<Instituto> listarTodo() {

        ArrayList<Instituto> listado = new ArrayList<>();

        String SSQL = "Select idInstituto, cedJuridica, codSede, nombreInstituto, ubicacionInstituto from Instituto";

        try {
            PreparedStatement pst = cn.prepareStatement(SSQL);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Instituto data = new Instituto();
                data.setIdInstituto(rs.getInt("idInstituto"));
                data.setCedJuridica(rs.getInt("cedJuridica"));
                data.setCodSede(rs.getInt("codSede"));
                data.setNombreInstituto(rs.getString("nombreInstituto"));
                data.setUbicacionInstituto(rs.getString("ubicacionInstituto"));

                listado.add(data);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al consultar instituto ::: {0}", ex.getLocalizedMessage());
        }
        return listado;
    }

    public int actualizar(int idInstituto, int cedJuridica, int codSede, String nombreInstituto, String ubicacionInstituto) {

        try {
            String sql = "UPDATE Instituto set  cedJuridica = ?, codSede=?, nombreInstituto = ?,ubicacionInstituto = ? "
                    + "WHERE idInstituto = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cedJuridica);
            statement.setInt(2, codSede);
            statement.setString(3, nombreInstituto);
            statement.setString(4, ubicacionInstituto);
            statement.setInt(5, idInstituto);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar instituto ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_MODIFICACION;
    }

    public int eliminar(int cod) {

        try {
            String sql = "DELETE FROM Instituto WHERE idInstituto = ?";

            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setInt(1, cod);

            int filasActualizadas = statement.executeUpdate();

            statement.close();

            if (filasActualizadas > 0) {
                return Constantes.EXITO;
            }
        } //FIN INSERTAR CURSO
        catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Excepcion al actualizar instituto ::: {0}", ex.getLocalizedMessage());
        }

        return Constantes.ERROR_ELIMINACION;
    }
}
