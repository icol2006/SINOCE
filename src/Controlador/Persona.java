package Controlador;

import java.util.Scanner;

public class Persona {

    Scanner entrada = new Scanner(System.in);
    private long cedulaPersona;
    private String nombrePersona;
    private String apellidosPersona;
    private String correoElectronico;
    private long telefono;

    public Persona() {
        cedulaPersona = 0;
        nombrePersona = "";
        apellidosPersona = "";
        correoElectronico = "";
        telefono = 0;
    }

    public void insertarPersona() {
        System.out.println("Ingrese la cédula");
        cedulaPersona = entrada.nextInt();

        System.out.println("Ingrese el nombre");
        nombrePersona = entrada.next();
    }

    public Boolean buscarCedula() {

        int cedBuscada;
        boolean cedB = false;
        System.out.println("Ingrese la cédula a buscar ");
        cedBuscada = entrada.nextInt();
        if (cedBuscada == getCedulaPersona()
                ) {
            cedB = true;
        }
        return cedB;
    }// fin del métoto para buscar un curso por el código

    public Scanner getEntrada() {
        return entrada;
    }

    public void setEntrada(Scanner entrada) {
        this.entrada = entrada;
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

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
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
