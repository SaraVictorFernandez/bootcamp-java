package com.example;

public class Administrativo extends Empleado {
    
    private double precioHora;
    private int horasTrabajadas;
    
    public Administrativo(String id, String name, String email, double precioHora, int horasTrabajadas){
        super(id, name, email);
        this.precioHora = precioHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return precioHora*horasTrabajadas;
    }

    
}
