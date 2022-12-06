package com.example.demoFlowerStore.flower.store;
import java.util.ArrayList;

public class FlowerBucket{
    private double price;
    private ArrayList<FlowerPack> packs = new ArrayList<FlowerPack>();
    private int tulips = 0;
    private int chamomiles = 0;
    private int roses = 0;

    public void add(FlowerPack pack) {
        packs.add(pack);
        this.price += pack.getPrice();
        if (pack.getType().equals("Tulip")) {
            this.tulips += pack.getSize();
        } else if (pack.getType().equals("Rose")) {
            this.roses += pack.getSize();
        } else {
            this.chamomiles += pack.getSize();
        }
    }

    public double getPrice() {
        return price;
    }

    public String searchFlower(Flower flower){
        for (int i = 0; i < packs.size(); ++i) {
            if (packs.get(i).getType().equals(flower.getClass().getName())) {
                String message = flower.toString();
                return message;
            }
        }
        return flower.toString() + " not found";
    }

//    @Override
//    public String toString() {
//        String name = "";
//        for (int i = 0; i < packs.size(); ++i) {
//            FlowerPack pck = packs.get(i);
//            name += pck.toString();
//            name += "\n";
//        }
//        return name;
//    }

    public int getChamomiles() {
        return chamomiles;
    }

    public int getRoses() {
        return roses;
    }

    public int getTulips() {
        return tulips;
    }
}
