package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        Scanner scanner = new Scanner(System.in);
        int numEmpleados = scanner.nextInt();

        for(int i = 0; i < numEmpleados; i++) {
            System.out.println("Indica el tipo de empleado");
            System.out.println("    1. Gerente");
            System.out.println("    2. Ingeniero");
            System.out.println("    3. Administrativo");
            int tipo = scanner.nextInt();
            switch (tipo) {
                case 1:
                    empleados.add(leerGerente(scanner));
                    break;
                case 2:
                    empleados.add(leerIngeniero(scanner));
                    break;
                case 3:
                    empleados.add(leerAdministrativo(scanner));
                    break;
                default:
                    break;
            }
        }

        empleados.forEach((e) -> {
            e.describir();
            System.out.println("    Salario: " + e.calcularSalario());
        });

        scanner.close();
    }

    static Gerente leerGerente(Scanner scanner){
        System.out.println("Introduce el `id`, `nombre`, `email` y `bonus`");
        String id = scanner.next();
        String nombre = scanner.next();
        String email = scanner.next();
        double bonus = scanner.nextDouble();

        return new Gerente(id, nombre, email, bonus);
    }

    static Ingeniero leerIngeniero(Scanner scanner){
        System.out.println("Introduce el `id`, `nombre`, `email`, `precio/hora`y `horas trabajadas`");
        String id = scanner.next();
        String nombre = scanner.next();
        String email = scanner.next();
        double precioHora = scanner.nextDouble();
        int horas = scanner.nextInt();

        return new Ingeniero(id, nombre, email, precioHora, horas);
    }

    static Administrativo leerAdministrativo(Scanner scanner) {
        System.out.println("Introduce el `id`, `nombre`, `email`, `precio/hora`y `horas trabajadas`");
        String id = scanner.next();
        String nombre = scanner.next();
        String email = scanner.next();
        double precioHora = scanner.nextDouble();
        int horas = scanner.nextInt();

        return new Administrativo(id, nombre, email, precioHora, horas);
    }
}