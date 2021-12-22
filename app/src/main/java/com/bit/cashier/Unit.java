package com.bit.cashier;

public class Unit {
    private String name;
    private int count;
    private double value;
    public Unit(String name, int count){
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getValue() {
        value = Double.parseDouble(name) * count;
        return value;
    }
}
