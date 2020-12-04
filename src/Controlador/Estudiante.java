package Controlador;

import Modelo.Constantes;
import Modelo.EstudianteDAO;
import Modelo.InstitutoDAO;
import Modelo.PersonaDAO;
import java.util.ArrayList;

public class Estudiante extends Persona {

//variables de instancia
    private int idEstudiante;
    private String carneEstudiante;

//método constructor
    public Estudiante() {
        super();
        carneEstudiante = "";
    }

    public ArrayList<Estudiante> ListarTodo() {
        EstudianteDAO datos = new EstudianteDAO();
        ArrayList<Estudiante> listado = datos.ListarTodo();

        return listado;
    }

    public int buscarPorCedula(int cedPersona) {
        EstudianteDAO datos = new EstudianteDAO();
        Estudiante res = datos.buscarPorCedula(cedPersona);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdEstudiante(res.getIdEstudiante());
            this.setCarneEstudiante(res.getCarneEstudiante());
            this.setIdPersona(res.getIdPersona());
            this.setCedulaPersona(res.getCedulaPersona());
            this.setNombrePersona(res.getNombrePersona());
            this.setApellido1(res.getApellido1());
            this.setApellido2(res.getApellido2());
            this.setCorreoElectronico(res.getCorreoElectronico());

            return Constantes.EXITO;
        }
    }

    public int insertar(int idPersona, String carneEstudiante) {
        EstudianteDAO data = new EstudianteDAO();

        if (data.buscarPorIdPersona(idPersona) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(idPersona, carneEstudiante);
        }
    }

    public int actualizar(int idEstudiante, int idPersona, String carneEstudiante) {
        EstudianteDAO data = new EstudianteDAO();

        if (data.buscarPorIdEstudiante(idEstudiante) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idEstudiante, idPersona, carneEstudiante);
        }
    }

    public int eliminar(int id) {
        EstudianteDAO data = new EstudianteDAO();
        Estudiante resultado = data.buscarPorIdEstudiante(id);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(id);
        }
    }

    @Override
    public String toString() {
        return this.getNombrePersona() +" " + this.getApellido1()+" " + this.getApellido2();
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
     * @return the carneEstudiante
     */
    public String getCarneEstudiante() {
        return carneEstudiante;
    }

    /**
     * @param carneEstudiante the carneEstudiante to set
     */
    public void setCarneEstudiante(String carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }

}
