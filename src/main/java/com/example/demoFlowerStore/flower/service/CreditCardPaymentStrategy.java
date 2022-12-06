package com.example.demoFlowerStore.flower.service;


import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardPaymentStrategy implements Payment {

    @Getter
    private String cardNumber;
    @Getter
    private String CVV;
    @Getter
    private String expDate;

    public CreditCardPaymentStrategy(){};

    public CreditCardPaymentStrategy(String cardNumber, String CVV, String expDate) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expDate = expDate;
    }

    @Override
    public void collectPaymentDetails() {

    }

    public void collectPaymentDetails(String cardNumber, String CVV, String expDate) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expDate = expDate;
    }

    @Override
    public boolean validatePaymentDetails() {
        boolean numberVerified = false;
        boolean CVVVerified = false;
        boolean expDateVerified = false;

        String regex1 = "[0-9]{16}";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(this.cardNumber);
        if (matcher1.matches()) {
            numberVerified = true;
        }

        String regex2 = "[0-9]{3}";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(this.CVV);
        if (matcher2.matches()) {
            CVVVerified = true;
        }

        String regex3 = "[0-9]{2}/[0-9]{2}";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(this.expDate);
        if (matcher3.matches()) {
            expDateVerified = true;
        }

        if (numberVerified && CVVVerified && expDateVerified){
            return true;
        }

        return false;
    }

    @Override
    public void pay(double amount) {
        System.out.println("paying " + amount + " using credit card");
    }
}
