package com.example.demoFlowerStore.flower.store;

public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack() {
    }

    public FlowerPack(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public double getPrice() {
        double price = flower.getPrice() * quantity;
        return price;
    }

//    @Override
//    public String toString() {
//        String name = "";
//        name += Integer.toString(this.quantity);
//        name += " ";
//        name += flower.toString();
//        name += "s";
//        return name;
//    }

    public String getType() {
        return flower.getClass().getName();
    }

    public int getSize() {
        return this.quantity;
    }

}
