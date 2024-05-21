package proyectos.oop.pizzeria.src.main.java.com.example;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    List<Ingrediente> list;

    public Pizzeria(List<Ingrediente> list) {
        this.list = new ArrayList(list);
    }

    private void refillIngrediente(int ingredienteId, int quantity){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).ingredienteId == ingredienteId)
                list.get(i).unitCount += quantity;
        }
    }

    public void llenarAlmacen(List<Ingrediente> list) {
        for(int i = 0; i < list.size(); i++) {
            refillIngrediente(list.get(i).ingredienteId, list.get(i).unitCount);
        }
    }

    private boolean canFulfillPedido(Pedido pedido){
        List<Ingrediente> ingredientesGastados = new ArrayList<>();
        for(int i = 0; i < pedido.pizzaList.size(); i++){
            Pizza p = pedido.pizzaList.get(i);
            for(int j = 0; j < p.ingredientesId.size(); j++){
                boolean hasIngredient = false;
                for(int k = 0; k < ingredientesGastados.size(); k++){
                    if(ingredientesGastados.get(k).ingredienteId == p.ingredientesId.get(j)){
                        ingredientesGastados.get(k).unitCount++;
                        hasIngredient = true;
                    }
                }
                if(!hasIngredient){
                    ingredientesGastados.add(new Ingrediente(p.ingredientesId.get(j), "", 1, 0));
                }
            }
        }

        // check if we have all the ingredients
        for(int i = 0; i < ingredientesGastados.size(); i++){
            Ingrediente gastado = ingredientesGastados.get(i);
            boolean ingredienteEnAlmacen = false;
            for(int j = 0; j < list.size(); j++){
                Ingrediente stock = list.get(j);
                if(stock.ingredienteId == gastado.ingredienteId){
                    ingredienteEnAlmacen = true;
                    if(stock.unitCount < gastado.unitCount)
                        return false;
                }
            }
            if(!ingredienteEnAlmacen)
                return false;
        }
        return true;
    }

    public boolean pedirPizzas(Pedido pedido){
        if(!canFulfillPedido(pedido))
            return false;
        // descontar los ingredientes
        for(int i = 0; i < pedido.pizzaList.size(); i++){
            Pizza p = pedido.pizzaList.get(i);
            for(int j = 0; j < p.ingredientesId.size(); j++){
                int ingredienteGastadoId = p.ingredientesId.get(j);
                for(int k = 0; k < list.size(); k++){
                    if(list.get(k).ingredienteId == ingredienteGastadoId){
                        list.get(k).unitCount--;
                    }
                }
            }
        }
        return true;
    }

    public String getIngredientsStr(){
        String s = "";
        for(int i = 0; i < list.size(); i++){
            if(i > 0) s += ", ";
            s += list.get(i).name + "-" + list.get(i).unitCount;
        }
        return s;
    }
}
