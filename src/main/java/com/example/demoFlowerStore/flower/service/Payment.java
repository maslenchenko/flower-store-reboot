package com.example.demoFlowerStore.flower.service;

public interface Payment {
    void collectPaymentDetails();
    boolean validatePaymentDetails();
    void pay(double amount);
}
