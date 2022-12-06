package com.example.demoFlowerStore.flower.service;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostDeliveryStrategy implements Delivery{

    @Getter
    private String name;
    @Getter
    private String surname;
    @Getter
    private String city;
    @Getter
    private String phone;
    @Getter
    private String post;
    @Getter
    private double price;
    @Getter
    private double weight;

    public PostDeliveryStrategy(){};

    public PostDeliveryStrategy(String name, String surname, String city, String phone, String post, double weight) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.post = post;
        this.weight = weight;
    }

    @Override
    public void collectDeliveryDetails(){}

    public void collectDeliveryDetails(String name, String surname, String city, String phone, String post, double weight){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.post = post;
        this.weight = weight;
    }

    @Override
    public boolean validateDeliveryDetails(){
        boolean nameVerified = false;
        boolean surnameVerified = false;
        boolean cityVerified = false;
        boolean phoneVerified = false;
        boolean postVerified = false;

        String regex1 = "^[\\+]380[0-9]{9}";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(this.phone);
        if (matcher1.matches()) {
            phoneVerified = true;
        }

        String regex2 = "^[A-Z][a-z]+";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(this.city);
        if (matcher2.matches()) {
            cityVerified = true;
        }

        String regex3 = "^[A-Z][a-z]+";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(this.name);
        if (matcher3.matches()) {
            nameVerified = true;
        }

        String regex4 = "^[A-Z][a-z]+";
        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher(this.surname);
        if (matcher4.matches()) {
            surnameVerified = true;
        }

        String regex5 = "[0-9]{1,3}";
        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(this.post);
        if (matcher5.matches()) {
            postVerified = true;
        }

        if (nameVerified && surnameVerified && postVerified && cityVerified && phoneVerified){
            return true;
        }

        return false;
    }

    public double getPrice() {
        this.price = weight * 5;
        return price;
    }
}
