package proyectos.oop.pizzeria.src.main.java.com.example;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    int clientId;
    Date date;
    public List<Pizza> pizzaList;

    public Pedido(int clientId, Date date) {
        this.clientId = clientId;
        this.date = date;
        this.pizzaList = new ArrayList<Pizza>();
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }
}
