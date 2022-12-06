package com.example.demoFlowerStore.flower.store;

public class CactusFlower extends Item{
    private double price;
    private String description;

    @Override
    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
