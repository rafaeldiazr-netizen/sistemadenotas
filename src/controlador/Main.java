package controlador;

import modelo.Estudiante;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante(
                "Rafael Diaz",
                "Programación Orientada a Objetos",
                4.5,
                3.8
        );

        System.out.println("================================");
        System.out.println(" SISTEMA DE NOTAS ");
        System.out.println("================================");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Asignatura: " + estudiante.getAsignatura());
        System.out.println("Nota 1: " + estudiante.getNota1());
        System.out.println("Nota 2: " + estudiante.getNota2());
        System.out.println("Promedio: " + estudiante.getPromedio());
        System.out.println("Estado: " + estudiante.getEstado());
    }
}