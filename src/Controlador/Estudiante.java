package Controlador;

import Modelo.Constantes;
import Modelo.EstudianteDAO;

public class Estudiante extends Persona {

//variables de instancia
    private String carneEstudiante;

//método constructor
    public Estudiante() {
        super();
        carneEstudiante = "";
    }

    public int insertar(int cedPersona) {
        EstudianteDAO data = new EstudianteDAO();

        if (data.buscarPorCed(cedPersona) != null) {
            return Constantes.ERROR_GUARDAR_COD_EXISTENTE;
        } else {
            return data.insertar(cedPersona);
        }
    }

    public int actualizar(int cedPersona, int carneEstudiante) {
        EstudianteDAO data = new EstudianteDAO();

        if (data.buscarPorCed(cedPersona) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(cedPersona, carneEstudiante);
        }
    }

    public int eliminar(int cedPersona) {
        EstudianteDAO data = new EstudianteDAO();
        Estudiante resultado = data.buscarPorCed(cedPersona);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(cedPersona);
        }
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
