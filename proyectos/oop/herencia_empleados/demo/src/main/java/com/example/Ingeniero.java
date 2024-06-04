package com.example;

public class Ingeniero extends Empleado{

    private double sueldoHora;
    private int horasTrabajadas;

    public Ingeniero(String id, String name, String email, double sueldoHora, int horasTrabajadas) {
        super(id, name, email);
        this.sueldoHora = sueldoHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return sueldoHora*horasTrabajadas;
    }

    @Override
    public void describir() {
        System.out.println("El ingeniero " + name + " tiene el id " + id + " y el email " + email);
    }
}
