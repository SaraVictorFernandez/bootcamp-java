package com.example;

public abstract class Empleado {
    protected String id;
    protected String name;
    protected String email;

    Empleado(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void describir() {
        System.out.println("El empleado " + name + " tiene el id " + id + " y el email " + email);
    }

    public abstract double calcularSalario();
}
