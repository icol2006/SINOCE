package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante extends Persona {
//variables de instancia

    Scanner entrada = new Scanner(System.in);
    ArrayList<Estudiante> ListaEstudiantes = new ArrayList<>();
    private String carneEstudiante;

//método constructor
    public Estudiante() {
        super();
        carneEstudiante = "";
    }

//métodos de la clase 
    //método para ingresar estudiantes, será usado desde el main
    public void ingresarEstudiante() {
//método para ingresar un estudiante, implementando la herencia

        System.out.print("Ingrese el nombre: ");
        setNombrePersona(entrada.nextLine());

        System.out.print("Ingrese los apellidos: ");
        setApellidosPersona(entrada.nextLine());

        System.out.print("Ingrese la cédula: ");
        setCedulaPersona(entrada.nextLong());

        System.out.print("Ingrese el carné: ");
        carneEstudiante = entrada.next();

        System.out.print("Ingrese un correo eléctronico: ");
        setCorreoElectronico(entrada.next());

        System.out.print("Ingrese el teléfono: ");
        setTelefono(entrada.nextInt());
    }
//método de tipo ArrayLis para ingresar una lista de estudiates, se invoca desde el main

    public ArrayList<Estudiante> ingresarEstudiante(int cant) {

        for (int x = 1; x <= cant; x++) {
            Estudiante est = new Estudiante();
            System.out.print("Ingrese el nombre: ");
            est.setNombrePersona(entrada.nextLine());

            System.out.print("Ingrese los apellidos: ");
            est.setApellidosPersona(entrada.nextLine());

            System.out.print("Ingrese la cédula: ");
            String ced = entrada.nextLine();
            est.setCedulaPersona(Integer.parseInt(ced));

            System.out.print("Ingrese el carné: ");
            est.carneEstudiante = entrada.nextLine();

            System.out.print("Ingrese el teléfono: ");
            String tel = entrada.nextLine();
            est.setTelefono(Integer.parseInt(tel));

            System.out.print("Ingrese un correo eléctronico: ");
            est.setCorreoElectronico(entrada.nextLine());

            ListaEstudiantes.add(est);
            System.out.println();
        }

        return ListaEstudiantes;

    }
//método para mostrar la lista de estudiantes 

    public void mostrarEstudiante() {

        for (int x = 0; x < ListaEstudiantes.size(); x++) {
            System.out.println("Nombre: " + ListaEstudiantes.get(x).getNombrePersona());
            System.out.println("Apellidos: " + ListaEstudiantes.get(x).getApellidosPersona());
            System.out.println("Carné de estudiante: " + ListaEstudiantes.get(x).carneEstudiante);
            System.out.println("Correo: " + ListaEstudiantes.get(x).getCorreoElectronico());
            System.out.println("Teléfono: " + ListaEstudiantes.get(x).getTelefono());
            System.out.println();

        }

    }
//método para buscar un estudiante por cédula 

    @Override
    public Boolean buscarCedula() {
        int cedBuscada;
        boolean cedB = false;
        System.out.println("Ingrese la cédula a buscar ");
        cedBuscada = entrada.nextInt();
        if (cedBuscada == getCedulaPersona()) {
            cedB = true;
        }
        return cedB;
    }// fin del métoto para buscar un estudiante por cédula

    //métodos set y get de la clase 
    public String getCarneEstudiante() {
        return carneEstudiante;
    }

    public void setCarneEstudiante(String carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }

}
