package modelo;

public class Estudiante extends Persona {

    private String asignatura;
    private double nota1;
    private double nota2;
    private double promedio;
    private String estado;

    public Estudiante() {
    }

    public Estudiante(String nombre,
                      String asignatura,
                      double nota1,
                      double nota2) {

        super(nombre);

        this.asignatura = asignatura;
        this.nota1 = nota1;
        this.nota2 = nota2;

        calcularPromedio();
        calcularEstado();
    }

    public void calcularPromedio() {

        promedio = (nota1 + nota2) / 2;

    }

    public void calcularEstado() {

        if (promedio < 2) {

            estado = "Pierde";

        } else if (promedio < 3) {

            estado = "Habilita";

        } else {

            estado = "Gana";

        }

    }

    public String getAsignatura() {
        return asignatura;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getEstado() {
        return estado;
    }

}