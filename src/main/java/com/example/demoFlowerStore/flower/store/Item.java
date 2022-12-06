package com.example.demoFlowerStore.flower.store;

abstract class Item {
    private String description;

    public Item() {}
    public Item(String description) {
        this.description = description;
    }

    abstract String getDescription();

    public void setDescription(String description) {
        this.description = description;
    }

    abstract double getPrice();
}
