package com.example.demoFlowerStore.flower.store;

public class RibbonDecorator extends ItemDecorator{

    private Item item;

    public RibbonDecorator(Item item){
        this.item = item;
    }

    @Override
    public double getPrice() {
        double price = 0;
        price += item.getPrice();
        price += 40.0;
        return price;
    }

    @Override
    public String getDescription() {
        String description = "";
        description += item.getDescription();
        description += "\nWRAPPER: ribbon";
        return description;
    }
}
