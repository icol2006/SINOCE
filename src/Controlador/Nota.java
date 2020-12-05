/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import Modelo.NotaDAO;
import java.util.ArrayList;

public class Nota {

    private int idNota;
    private int codCurso;
    private int idEstudiante;
    private int calificacion;

    private Estudiante estudiante;
    private Curso curso;

    public Nota() {
        idNota = 0;
        codCurso = 0;
        idEstudiante = 0;
        calificacion = 0;
        estudiante = new Estudiante();
        curso = new Curso();
    }

    public ArrayList<Nota> ListarNotasPorCurso(int codCurso) {
        NotaDAO nota = new NotaDAO();
        ArrayList<Nota> listado = nota.ListarNotasPorCurso(codCurso);

        return listado;
    }

    public int BuscarPorIdEstudianteIdCurso(int idEstudiante,int codCurso) {
        NotaDAO nota = new NotaDAO();
        Nota n = nota.BuscarPorIdEstudianteIdCurso(idEstudiante,codCurso);

        if (n == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdNota(n.getIdNota());
            this.setIdEstudiante(n.getIdEstudiante());
            this.setCurso(n.getCurso());
            this.setCalificacion(n.getCalificacion());

            return Constantes.EXITO;
        }
    }


    public int Insertar(int idEstudiante, int codCurso, int calificacion) {
        NotaDAO nota = new NotaDAO();

        return nota.Insertar(idEstudiante, codCurso, calificacion);

    }

    public int Actualizar(int idNota, int idEstudiante, int codCurso, int calificacion) {
        NotaDAO nota = new NotaDAO();

        return nota.Actualizar(idNota, idEstudiante, codCurso, calificacion);
    }

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
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
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
