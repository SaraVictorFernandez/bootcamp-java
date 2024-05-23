package com.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Ingrediente> getIngredientes() {
        Ingrediente ingrediente = new Ingrediente(1, "Queso", 5, 10);
        Ingrediente ingrediente2 = new Ingrediente(2, "Tomate", 5, 10);
        Ingrediente ingrediente3 = new Ingrediente(3, "Jamón", 5, 10);
        
        List<Ingrediente> ingredientsList = List.of(ingrediente, ingrediente2, ingrediente3);
        return ingredientsList;
    }

    private static Pizza getPizza1(){
        List<Ingrediente> ingredients = getIngredientes();
        Pizza pizza = new Pizza(List.of(ingredients.get(0).ingredienteId, ingredients.get(1).ingredienteId));
        return pizza;
    }

    private static Pizza getPizza2(){
        List<Ingrediente> ingredients = getIngredientes();
        Pizza pizza = new Pizza(List.of(ingredients.get(2).ingredienteId, ingredients.get(1).ingredienteId));
        return pizza;
    }

    private static Pedido getPedido1(){
        Pedido pedido = new Pedido(1, new Date(2024, 5, 21));
        pedido.addPizza(getPizza1());
        pedido.addPizza(getPizza2());
        return pedido;
    }
    private static Pedido getPedido2(){
        Pedido pedido = new Pedido(1, new Date(2024, 5, 21));
        pedido.addPizza(getPizza2());
        pedido.addPizza(getPizza2());
        return pedido;
    }

    private static void refillIngredientes(Pizzeria p){
        for(int i=0; i<p.ingredientes.size(); i++){
            p.ingredientes.get(i).unitCount++;
        }
    }

    public static void main(String[] args) {
        List<Ingrediente> ingredientsList = getIngredientes();
        Pizzeria pizzeria = new Pizzeria(ingredientsList);
        Pedido pedido = getPedido1();
        Pedido pedido2 = getPedido2();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Options : ");
        System.out.println("    0. Exit");
        System.out.println("    1. See ingredients");
        System.out.println("    2. Create order 1");
        System.out.println("        Pizza 1: " + getPizza1().getUsedIngredientsStr(ingredientsList));
        System.out.println("        Pizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList));
        System.out.println("    3. Create order 2");
        System.out.println("        Pizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList));
        System.out.println("        Pizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList));
        System.out.println("    4. Add ingredients");
        System.out.println("        Jamón: 1");
        System.out.println("        Tomate: 1");
        System.out.println("        Queso: 1");

        int option = scanner.nextInt();
        while(option != 0){
            switch (option) {
                case 1:
                    System.out.println(pizzeria.getIngredientsStr());
                    break;
                case 2:
                    boolean orderResult = pizzeria.pedirPizzas(pedido);
                    if(orderResult) System.out.println("Se han pedido las pizzas");
                    else System.out.println("No hay suficientes ingredientes");
                    break;
                case 3:
                    orderResult = pizzeria.pedirPizzas(pedido2);
                    if(orderResult) System.out.println("Se han pedido las pizzas");
                    else System.out.println("No hay suficientes ingredientes");
                    break;

                case 4:
                    refillIngredientes(pizzeria);
                    System.out.println("Se han añadido ingredientes");
                    break;
                default:
                    break;
            }
            option = scanner.nextInt();
        }
    }
}