package com.example;

public class Ingrediente {
    int ingredienteId;
    public String name;
    int unitCount;
    int unitCost;

    public Ingrediente(int ingredienteId, String name, int unitCount, int unitCost) {
        this.ingredienteId = ingredienteId;
        this.name = name;
        this.unitCount = unitCount;
        this.unitCost = unitCost;
    }
}
