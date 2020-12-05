/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import Modelo.EstudianteDAO;
import Modelo.ProfesorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class Profesor extends Persona {

    private int idProfesor;
    private String especialidadProfesor;
    private String profesionProfesor;

    public Profesor() {
        super();
        idProfesor = 0;
        especialidadProfesor = "";
        profesionProfesor = "";
    }

    public ArrayList<Profesor> ListarTodo() {
        ProfesorDAO datos = new ProfesorDAO();
        ArrayList<Profesor> listado = datos.listarTodo();

        return listado;
    }

    public int buscarPorCedula(int cedPersona) {
        ProfesorDAO datos = new ProfesorDAO();
        Profesor res = datos.buscarPorCedula(cedPersona);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdProfesor(res.getIdProfesor());
            this.setEspecialidadProfesor(res.getEspecialidadProfesor());
            this.setProfesionProfesor(res.getProfesionProfesor());
            this.setIdPersona(res.getIdPersona());
            this.setCedulaPersona(res.getCedulaPersona());
            this.setNombrePersona(res.getNombrePersona());
            this.setApellido1(res.getApellido1());
            this.setApellido2(res.getApellido2());
            this.setCorreoElectronico(res.getCorreoElectronico());

            return Constantes.EXITO;
        }
    }

    public int buscarPorCodCurso(int codCurso) {
        ProfesorDAO datos = new ProfesorDAO();
        Profesor res = datos.buscarPorCodCurso(codCurso);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdProfesor(res.getIdProfesor());
            this.setEspecialidadProfesor(res.getEspecialidadProfesor());
            this.setProfesionProfesor(res.getProfesionProfesor());
            this.setIdPersona(res.getIdPersona());
            this.setCedulaPersona(res.getCedulaPersona());
            this.setNombrePersona(res.getNombrePersona());
            this.setApellido1(res.getApellido1());
            this.setApellido2(res.getApellido2());
            this.setCorreoElectronico(res.getCorreoElectronico());

            return Constantes.EXITO;
        }
    }

    public int insertar(String especialidadProfesor, String profesionProfesor, int idPersona, int cedPersona) {
        ProfesorDAO data = new ProfesorDAO();

        if (data.buscarPorCedula(cedPersona) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(especialidadProfesor, profesionProfesor, idPersona);
        }
    }

    public int actualizar(int idProfesor, String especialidadProfesor, String profesionProfesor, int idPersona) {
        ProfesorDAO data = new ProfesorDAO();
        Profesor resultado = data.buscarPorIdProfesor(idProfesor);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idProfesor, especialidadProfesor, profesionProfesor, idPersona);
        }
    }

    public int eliminar(int idProfesor) {
        ProfesorDAO data = new ProfesorDAO();
        Profesor resultado = data.buscarPorIdProfesor(idProfesor);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(idProfesor);
        }
    }

    @Override
    public String toString() {
        return "Cedula:" + this.getCedulaPersona() + " - " + this.getNombrePersona() + " " + this.getApellido1() + " " + this.getApellido2();
    }

    /**
     * @return the idProfesor
     */
    public int getIdProfesor() {
        return idProfesor;
    }

    /**
     * @param idProfesor the idProfesor to set
     */
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    /**
     * @return the especialidadProfesor
     */
    public String getEspecialidadProfesor() {
        return especialidadProfesor;
    }

    /**
     * @param especialidadProfesor the especialidadProfesor to set
     */
    public void setEspecialidadProfesor(String especialidadProfesor) {
        this.especialidadProfesor = especialidadProfesor;
    }

    /**
     * @return the profesionProfesor
     */
    public String getProfesionProfesor() {
        return profesionProfesor;
    }

    /**
     * @param profesionProfesor the profesionProfesor to set
     */
    public void setProfesionProfesor(String profesionProfesor) {
        this.profesionProfesor = profesionProfesor;
    }

    public String nombreCompleto()
    {
        return this.getNombrePersona()+ " "+ this.getApellido1()+ " " +this.getApellido2();
    }
}
