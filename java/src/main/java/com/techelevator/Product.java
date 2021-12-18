package com.techelevator;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private BigDecimal price;
    private String sound;

    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract String getSound();

    @Override
    public String toString() {
        return name + " $" + price;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

}
