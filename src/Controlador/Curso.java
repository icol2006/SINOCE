package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Presentacion.InsertaCurso;
import java.util.ArrayList;

public class Curso {
//declaración de variables de instancia

    private String nombreCurso;
    private int codCurso;
    private int horas;
    private String periodo;

    private Profesor profesor;

//método constructor sin parámetros
    public Curso() {
        nombreCurso = "";
        codCurso = 0;
        horas = 0;
        periodo = "";
        profesor = new Profesor();
    }
//método constructor con parámetros

    public Curso(String nomCurso, int codC, int horasC, String periodoC, Profesor profesorC) {
        nomCurso = this.nombreCurso;
        this.codCurso = codC;
        this.horas = horasC;
        this.periodo = periodoC;
        this.profesor = profesorC;
    }

    /*
//operacion para ingresar cursos en consola
    public void ingresarCurso() {

        System.out.println("Ingrese el nombre del curso");
        nombreCurso = entrada.next();

        System.out.println("Ingrese el código del curso");
        codCurso = entrada.nextInt();

        System.out.println("Ingrese la duración en horas del curso");
        horas = entrada.nextInt();

    }// fin del método para ingresar cursos

     */
    // insertar cursos en la BD
    public int insertarCursosBD(int cod, String nombreCurso, int duracion) {
        CursoDAO curso = new CursoDAO();

        if (curso.buscarCursoPorCod(cod) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return curso.insertarCurso(cod, nombreCurso, duracion);
        }
    }

    public ArrayList<Curso> ListarCursos() {
        CursoDAO curso = new CursoDAO();
        ArrayList<Curso> listado = curso.listarCursos();

        return listado;
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

    public int actualizarCurso(int cod, String nombreCurso, int duracion) {
        CursoDAO curso = new CursoDAO();
        Curso c = curso.buscarCursoPorCod(cod);

        if (c == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return curso.actualizarCurso(cod, nombreCurso, duracion);
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

}
