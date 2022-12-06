package com.example.demoFlowerStore.flower.store;

public class BasketDecorator extends ItemDecorator{

    private Item item;

    public BasketDecorator(Item item){
        this.item = item;
    }

    @Override
    public double getPrice() {
        double price = 0;
        price += item.getPrice();
        price += 4.0;
        return price;
    }

    @Override
    public String getDescription() {
        String description = "";
        description += item.getDescription();
        description += "\nWRAPPER: basket";
        return description;
    }
}
