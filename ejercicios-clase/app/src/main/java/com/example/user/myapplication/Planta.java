package com.example.user.myapplication;

// Esta clase es un POJO (Plain Old Java Object)

public class Planta {
    private int id;
    private String name;
    private Float price;

    public Planta(int id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
