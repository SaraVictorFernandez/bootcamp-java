package com.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Ingrediente> getIngredientes() {
        
        Ingrediente ingrediente = new Ingrediente(1, "Queso", 5, 10);
        Ingrediente ingrediente2 = new Ingrediente(2, "Tomate", 5, 10);
        Ingrediente ingrediente3 = new Ingrediente(3, "Jamón", 5, 10);
        Ingrediente ingrediente4 = new Ingrediente(4, "Champiñón", 5, 10);
        Ingrediente ingrediente5 = new Ingrediente(5, "Masa de pizza", 5, 10);
        
        List<Ingrediente> ingredientsList = List.of(ingrediente, ingrediente2, ingrediente3, ingrediente4, ingrediente5);
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
        Pedido order = new Pedido(1, new Date(2024, 5, 21));
        order.addPizza(getPizza1());
        order.addPizza(getPizza2());
        return order;
    }
    private static Pedido getPedido2(){
        Pedido order = new Pedido(1, new Date(2024, 5, 21));
        order.addPizza(getPizza2());
        order.addPizza(getPizza2());
        return order;
    }

    private static void refillIngredientes(Pizzeria p){
        for(int i=0; i<p.ingredientes.size(); i++){
            p.ingredientes.get(i).unitCount++;
        }
    }

    public static void main(String[] args) {
        List<Ingrediente> ingredientsList = getIngredientes();
        Pizzeria pizzeria = new Pizzeria(ingredientsList);
        Pedido order1 = getPedido1();
        Pedido order2 = getPedido2();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Options : ");
        System.out.println("\t0. Exit");
        System.out.println("\t1. See ingredients");
        System.out.println("\t2. Create order 1\n\t\tPizza 1: " + getPizza1().getUsedIngredientsStr(ingredientsList)+"\n\t\tPizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList));
        System.out.println("\t3. Create order 2\n\t\tPizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList)+"\n\t\tPizza 2: " + getPizza2().getUsedIngredientsStr(ingredientsList));
        System.out.println("\t4. Add ingredients\n\t\tJamón: 1\n\t\tTomate: 1\n\t\tQueso: 1\n\t\tChampiñón: 1\n\t\tMasa de pizza: 1");

        int option = scanner.nextInt();
        while(option != 0){
            switch (option) {
                case 1:
                    System.out.println(pizzeria.getIngredientsStr());
                    break;
                case 2:
                    boolean orderResult = pizzeria.pedirPizzas(order1);
                    if(orderResult) System.out.println("Se han pedido las pizzas");
                    else System.out.println("No hay suficientes ingredientes");
                    break;
                case 3:
                    orderResult = pizzeria.pedirPizzas(order2);
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