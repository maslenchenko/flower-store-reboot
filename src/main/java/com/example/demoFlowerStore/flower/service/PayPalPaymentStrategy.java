package com.example.demoFlowerStore.flower.service;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PayPalPaymentStrategy implements Payment {
    @Getter
    private String email;
    @Getter
    private String password;

    public PayPalPaymentStrategy(){};

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void collectPaymentDetails() {

    }

    public void collectPaymentDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validatePaymentDetails() {
        boolean passwordVerified = false;
        boolean emailVerified = false;

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);
        if (matcher.matches()) {
            emailVerified = true;
        }

        String regex1 = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(this.password);
        if (matcher1.matches()) {
            passwordVerified = true;
        }

        if (passwordVerified && emailVerified) {
            return true;
        }
        return false;
    }

    @Override
    public void pay(double amount) {
        System.out.println("paying " + amount + " using PayPal");
    }

}
