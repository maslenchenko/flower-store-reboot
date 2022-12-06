package com.example.demoFlowerStore.flower.store;

public class PaperDecorator extends ItemDecorator{

    private Item item;

    public PaperDecorator(Item item){
        this.item = item;
    }

    @Override
    public double getPrice() {
        double price = 0;
        price += item.getPrice();
        price += 13.0;
        return price;
    }

    @Override
    public String getDescription() {
        String description = "";
        description += item.getDescription();
        description += "\nWRAPPER: paper";
        return description;
    }
}
