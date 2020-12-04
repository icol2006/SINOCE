package Controlador;

import Modelo.Constantes;
import Modelo.EstudianteDAO;
import Modelo.InstitutoDAO;
import Modelo.PersonaDAO;
import java.util.Scanner;

public class Persona {

    private int idPersona;
    private long cedulaPersona;
    private String nombrePersona;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;
    private long telefono;

    public Persona() {
        idPersona = 0;
        cedulaPersona = 0;
        nombrePersona = "";
        apellido1 = "";
        apellido2 = "";
        correoElectronico = "";
        telefono = 0;
    }

    public int buscarPorCedula(int cedPersona) {
        PersonaDAO datos = new PersonaDAO();
        Persona res = datos.buscarPorCed(cedPersona);

        if (res == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            this.setIdPersona(res.getIdPersona());
            this.setCedulaPersona(res.getCedulaPersona());
            this.setNombrePersona(res.getNombrePersona());
            this.setApellido1(res.getApellido1());
            this.setApellido2(res.getApellido2());
            this.setCorreoElectronico(res.getCorreoElectronico());

            return Constantes.EXITO;
        }
    }

    public int insertar(int cedPersona, String nombrePersona, String apellido1, String apellido2, String correoPersonal) {
        PersonaDAO data = new PersonaDAO();

        return data.insertar(cedPersona, nombrePersona, apellido1, apellido2, nombrePersona);
    }

    public int actualizar(int idPersona, int cedPersona, String nombrePersona, String apellido1, String apellido2, String correoPersonal) {
        PersonaDAO data = new PersonaDAO();

        if (data.buscarPorIdPersona(idPersona) == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.actualizar(idPersona, cedPersona, nombrePersona, apellido1, apellido2, correoPersonal);
        }
    }

    public int eliminar(int carneEstudiante) {
        PersonaDAO data = new PersonaDAO();
        Persona resultado = data.buscarPorIdPersona(carneEstudiante);

        if (resultado == null) {
            return Constantes.ERROR_CONSULTA_NO_EXISTE;
        } else {
            return data.eliminar(carneEstudiante);
        }
    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public long getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(long cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
