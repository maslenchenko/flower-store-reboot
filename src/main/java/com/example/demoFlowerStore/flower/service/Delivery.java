package com.example.demoFlowerStore.flower.service;

interface Delivery {
    void collectDeliveryDetails();
    boolean validateDeliveryDetails();
    double getPrice();
}
