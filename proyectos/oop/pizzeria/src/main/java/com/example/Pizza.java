package com.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    public List<Integer> ingredientesId;

    public Pizza(List<Integer> ingredientes){
        this.ingredientesId = new ArrayList<Integer>(ingredientes);
    }

    private String getIngredientName(List<Ingrediente> ingredients, int ingredientId){
        for(int i = 0; i < ingredients.size(); i++){
            if(ingredients.get(i).ingredienteId == ingredientId)
                return ingredients.get(i).name;
        }
        return "";
    }

    public String getUsedIngredientsStr(List<Ingrediente> ingredients){
        String s = "";

        for(int i = 0; i < ingredientesId.size(); i++){
            if(i > 0) s += ", ";
            s += getIngredientName(ingredients, ingredientesId.get(i));
        }

        return s;
    }
}
