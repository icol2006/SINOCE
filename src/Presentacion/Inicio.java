package Presentacion;
// clase inicio que contiene el método main

import Controlador.Curso;
import Controlador.Usuario;
import Controlador.Estudiante;
import Modelo.UsuarioDAO;
import java.sql.SQLException;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Inicio {//inicio de la clase Inicio
//Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {//inicio del método main
        Scanner teclado = new Scanner(System.in);
        /*
        Curso c1 = new Curso();
        c1.ingresarCurso();
        if (c1.buscarIdCurso()) {
            System.out.println("El curso existe");
            System.out.println("Nombre: " + c1.getNombreCurso());
        } else {
            System.out.println("El curso NO existe");

        }//fin del bloque if...else

        //Este es el llamado al constructor con parámetros 
        // Curso c2 = new Curso("Ciencias", 001, 40, "27/05/209", "20/08/2019");
        //Por ahora, solo se incluye para ejemplificar
    
        Estudiante estu = new Estudiante();
        Scanner entrada = new Scanner(System.in);
        // estu.ingresarEstudiante();
        //int cantE = 0;
        //  System.out.print("¿Cuántos estudiantes desea ingresar? ---> ");
        //  cantE = entrada.nextInt();
        // estu.ingresarEstudiante(cantE);
        estu.ingresarEstudiante();
        estu.mostrarEstudiante();

        
        if (estu.buscarCedula()) {
            System.out.println("Nombre: " + estu.getNombrePersona());
            System.out.println("Apellidos: " + estu.getApellidosPersona());
            System.out.println("Cédula: " + estu.getCedulaPersona());
            System.out.println("Carné estudiante: " + estu.getCarneEstudiante());
            System.out.println("Telefono: " + estu.getTelefono());
        } else {
            System.out.println("El estudiante NO existe");
        }//fin del bloque if...else
         */

//**********************Provar la conexión a BD
        UsuarioDAO us = new UsuarioDAO();
        /*
        String usuario;
        String clave;
        System.out.println("Ingrese su usuario");

        usuario = teclado.next();

        System.out.println("Ingrese su usuario");

        clave = teclado.next();

    

        if (us.ConexionUsuario() == 1) {
            JOptionPane.showMessageDialog(null, "¡Conexión correcta!", "Mensaje al ususario", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡Conexión fallida!", "Mensaje al ususario", JOptionPane.WARNING_MESSAGE);
        }
*/

    }//fin del método main

}//fin de la clase

