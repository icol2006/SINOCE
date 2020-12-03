/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Constantes;
import Modelo.CursoDAO;
import Modelo.ProfesorDAO;

public class Profesor extends Persona {

    private int codProfesor;
    private String especialidadProfesor;
    private String profesionProfesor;

    public Profesor() {
        super();
        codProfesor = 0;
        especialidadProfesor = "";
        profesionProfesor = "";
    }

    public int insertar(String especialidadProfesor, String profesionProfesor, int cedPersona) {
        ProfesorDAO data = new ProfesorDAO();

        if (data.buscarPorCed(cedPersona) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(especialidadProfesor, profesionProfesor, cedPersona);
        }
    }

    public int actualizar(String especialidadProfesor, String profesionProfesor, int cedPersona, int codProfesor) {
        ProfesorDAO data = new ProfesorDAO();
        Profesor resultado = data.buscarPorCed(cedPersona);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(especialidadProfesor, profesionProfesor, cedPersona, codProfesor);
        }
    }

    public int eliminar(int cedPersona) {
        ProfesorDAO data = new ProfesorDAO();
        Profesor resultado = data.buscarPorCed(cedPersona);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(cedPersona);
        }
    }

    /**
     * @return the codProfesor
     */
    public int getCodProfesor() {
        return codProfesor;
    }

    /**
     * @param codProfesor the codProfesor to set
     */
    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
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

}
