/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.EstudianteDAO;
import Modelo.MatriculaDAO;
import java.sql.Date;

public class Matricula {

    private long idMatricula;
    private String periodoMatricula;
    private int codCurso;
    private int carneEstudiante;
    private int codSede;
    private Date fechaInicio;
    private Date fechaConclusion;

    public Matricula() {
        idMatricula = 0;
        periodoMatricula = "";
        codCurso = 0;
        carneEstudiante = 0;
        codSede = 0;
        fechaInicio = null;
        fechaConclusion = null;
    }

    public int insertar(String periodoMatricula, int codCurso, int carneEstudiante, int codSede, Date fechaInicio, Date fechaConclusion) {
        MatriculaDAO data = new MatriculaDAO();

        if (data.buscarPorPerido_CodCurso_CarEstudiante_CodSede(periodoMatricula, codCurso, carneEstudiante, codSede) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(periodoMatricula, codCurso, carneEstudiante, codSede, fechaInicio, fechaConclusion);
        }
    }

    public int actualizar(int idMatricula, String periodoMatricula, int codCurso, int carneEstudiante, int codSede,
            Date fechaInicio, Date fechaConclusion) {
        MatriculaDAO data = new MatriculaDAO();

        if (data.buscarPorId(idMatricula) != null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idMatricula, periodoMatricula, codCurso, carneEstudiante, codSede, fechaInicio, fechaConclusion);
        }
    }

    public int eliminar(int idMatricula) {
        MatriculaDAO data = new MatriculaDAO();

        if (data.buscarPorId(idMatricula) != null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(idMatricula);
        }
    }

    /**
     * @return the idMatricula
     */
    public long getIdMatricula() {
        return idMatricula;
    }

    /**
     * @param idMatricula the idMatricula to set
     */
    public void setIdMatricula(long idMatricula) {
        this.idMatricula = idMatricula;
    }

    /**
     * @return the periodoMatricula
     */
    public String getPeriodoMatricula() {
        return periodoMatricula;
    }

    /**
     * @param periodoMatricula the periodoMatricula to set
     */
    public void setPeriodoMatricula(String periodoMatricula) {
        this.periodoMatricula = periodoMatricula;
    }

    /**
     * @return the codCurso
     */
    public int getCodCurso() {
        return codCurso;
    }

    /**
     * @param codCurso the codCurso to set
     */
    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * @return the carneEstudiante
     */
    public int getCarneEstudiante() {
        return carneEstudiante;
    }

    /**
     * @param carneEstudiante the carneEstudiante to set
     */
    public void setCarneEstudiante(int carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }

    /**
     * @return the codSede
     */
    public int getCodSede() {
        return codSede;
    }

    /**
     * @param codSede the codSede to set
     */
    public void setCodSede(int codSede) {
        this.codSede = codSede;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaConclusion
     */
    public Date getFechaConclusion() {
        return fechaConclusion;
    }

    /**
     * @param fechaConclusion the fechaConclusion to set
     */
    public void setFechaConclusion(Date fechaConclusion) {
        this.fechaConclusion = fechaConclusion;
    }

}
