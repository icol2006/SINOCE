package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Presentacion.FrmInsertaCurso;
import java.sql.Date;
import java.util.ArrayList;

public class Curso {


//declaración de variables de instancia
    private String nombreCurso;
    private int codCurso;
    private int horas;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFinal;

    private Profesor profesor;
    private ArrayList<Estudiante> listadoEstudiantes;

//método constructor sin parámetros
    public Curso() {
        nombreCurso = "";
        codCurso = 0;
        horas = 0;
        periodo = "";
        profesor = new Profesor();
        listadoEstudiantes = new ArrayList<Estudiante>();
    }
//método constructor con parámetros

    public Curso(String nomCurso, int codC, int horasC, String periodoC, Profesor profesorC) {
        nomCurso = this.nombreCurso;
        this.codCurso = codC;
        this.horas = horasC;
        this.periodo = periodoC;
        this.profesor = profesorC;
    }

    public ArrayList<Curso> ListarTodo() {
        CursoDAO curso = new CursoDAO();
        ArrayList<Curso> listado = curso.ListarTodo();

        return listado;
    }

    public ArrayList<Curso> ListarCursoProfesor() {
        CursoDAO curso = new CursoDAO();
        ArrayList<Curso> listado = curso.ListarCursoProfesor();

        return listado;
    }

    public Curso ListarCursoEstudiantes(int codCurso) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.ListarCursoEstudiantes(codCurso);

        return c;
    }

    public int Insertar(int cod, String nombreCurso, int duracion) {
        CursoDAO curso = new CursoDAO();

        if (curso.buscarCursoPorCod(cod) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return curso.Insertar(cod, nombreCurso, duracion);
        }
    }

    public int consultarCursoPorCodigo(int cod) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.buscarCursoPorCod(cod);

        if (c == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setCodCurso(c.getCodCurso());
            this.setHoras(c.getHoras());
            this.setNombreCurso(c.getNombreCurso());

            return Constantes.EXITO;
        }
    }

    public int ActualizarCurso(int cod, String nombreCurso, int duracion) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.buscarCursoPorCod(cod);

        if (c == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return curso.actualizarCurso(cod, nombreCurso, duracion);
        }
    }

    public int AgregarProfesorCurso(int idProfesor, int codCurso, String periodo) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.buscarCursoPorCod(codCurso);

        if (c == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return curso.AgregarProfesorCurso(idProfesor, codCurso, periodo);
        }
    }

    public int eliminarCurso(int cod) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.buscarCursoPorCod(cod);

        if (c == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return curso.eliminarCurso(cod);
        }
    }

    @Override
    public String toString() {
        return "Cod:" + this.getCodCurso() + " - " + this.getNombreCurso();
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the listadoEstudiantes
     */
    public ArrayList<Estudiante> getListadoEstudiantes() {
        return listadoEstudiantes;
    }

    /**
     * @param listadoEstudiantes the listadoEstudiantes to set
     */
    public void setListadoEstudiantes(ArrayList<Estudiante> listadoEstudiantes) {
        this.listadoEstudiantes = listadoEstudiantes;
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
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
