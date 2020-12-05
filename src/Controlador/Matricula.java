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
    private int idEstudiante;
    private int idInstituto;
    private Date fechaInicio;
    private Date fechaConclusion;

    public Matricula() {
        idMatricula = 0;
        periodoMatricula = "";
        codCurso = 0;
        idEstudiante = 0;
        idInstituto = 0;
        fechaInicio = null;
        fechaConclusion = null;
    }

    public int buscarPorCodCurso_IdEstudiante(int codCurso,
            int idEstudiante) {
        MatriculaDAO datos = new MatriculaDAO();
        Matricula res = datos.buscarPorCodCurso_IdEstudiante(codCurso, idEstudiante);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdMatricula(res.getIdMatricula());
            this.setPeriodoMatricula(res.getPeriodoMatricula());
            this.setCodCurso(res.getCodCurso());
            this.setIdEstudiante(res.getIdEstudiante());
            this.setIdInstituto(res.getIdInstituto());
            this.setFechaInicio(res.getFechaInicio());
            this.setFechaConclusion(res.getFechaConclusion());
            
            return Constantes.EXITO;
        }
    }

    public int insertar(String periodoMatricula, int codCurso, int idEstudiante, int idInstituto, Date fechaInicio, Date fechaConclusion) {
        MatriculaDAO data = new MatriculaDAO();

        if (data.buscarPorCodCurso_IdEstudiante(codCurso, idEstudiante)!= null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(periodoMatricula, codCurso, idEstudiante, idInstituto, fechaInicio, fechaConclusion);
        }
    }

    public int actualizar(int idMatricula, String periodoMatricula, int codCurso, int idEstudiante, int idInstituto,
            Date fechaInicio, Date fechaConclusion) {
        MatriculaDAO data = new MatriculaDAO();

        if (data.buscarPorId(idMatricula) != null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idMatricula, periodoMatricula, codCurso, idEstudiante, idInstituto, fechaInicio, fechaConclusion);
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
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param carneEstudiante the carneEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the codSede
     */
    public int getIdInstituto() {
        return idInstituto;
    }

    /**
     * @param codSede the codSede to set
     */
    public void setIdInstituto(int idInstituto) {
        this.idInstituto = idInstituto;
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
