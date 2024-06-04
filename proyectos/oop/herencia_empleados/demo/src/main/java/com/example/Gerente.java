package com.example;

public class Gerente extends Empleado {
    private static final double sueldoBase = 45000;
    private double bonus;

    public Gerente(String id, String name, String email, double bonus){
        super(id, name, email);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return sueldoBase + bonus;
    }

    @Override
    public void describir() {
        System.out.print("Gerente: ");
        super.describir();
    }
}
