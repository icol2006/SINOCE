/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import patron.LoggerHandlerSingleton;

/**
 *
 * @author yrojasp
 */
public class CursoDAO extends BDConexion {
    private final static Logger LOGGER = Logger.getLogger("Modelo.CursoDAO");

    Connection cn = conexion();
    
    public CursoDAO(){
        LOGGER.addHandler(LoggerHandlerSingleton.getInstance().getFh());
    }

    public int insertarCurso(int cod, String nomCurso, int duracion) {

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

    public Curso buscarCurso(int codCurso) {
        Curso c = null;
        
        String SSQL =   "Select codCurso, nombreCurso, horasDuracionCurso "
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
}
