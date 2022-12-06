package com.example.demoFlowerStore.flower.service;

import com.example.demoFlowerStore.flower.store.Flower;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Order {

    private List<Flower> flowers;
    private double price = 0;
    private static final Random RANDOM_GENERATOR = new Random();
    private Payment payment;
    private Delivery delivery;

    public Order() {

    }

    public void processOrder(Flower flowers[], boolean delivery, Payment payment) {
        Random rand = null;
        this.flowers = Arrays.asList(flowers);
        for (int i = 0; i < flowers.length; ++i) {
            price += this.flowers.get(i).getPrice();
        }
        this.delivery.collectDeliveryDetails();
        this.payment.collectPaymentDetails();
        if (this.payment.validatePaymentDetails() && this.delivery.validateDeliveryDetails()){
            this.price += this.delivery.getPrice();
            payment.pay(this.price);
        }
    }

    public double calculateTotalPrice(){
        return this.price;
    }

    public String checkOrder(){
        String order = "";
        for (int i = 0; i < this.flowers.size(); ++i) {
            order += this.flowers.get(i).toString();
            order += "\n";
        }
        return order;
    }

    public void removeItem(Flower flower){
        for (int i = 0; i < this.flowers.size(); ++i) {
            if (this.flowers.get(i) == flower) {
                this.flowers.remove(i);
            }
        }
    }

    public void addItem(Flower flower) {
        this.flowers.add(flower);
    }

    public void cancellOrder() {
        this.price = 0;
        for (int i = 0; i < this.flowers.size(); ++i) {
            this.flowers.remove(i);
        }
    }
}
