package com.example.demoFlowerStore;

import com.example.demoFlowerStore.flower.store.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestDecorators {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;


    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        RibbonDecorator ribbon = new RibbonDecorator(flower);
        BasketDecorator basket = new BasketDecorator(flower);
        PaperDecorator paper = new PaperDecorator(flower);
        Assertions.assertEquals(price + 4.0, basket.getPrice());
        Assertions.assertEquals(price + 40.0, ribbon.getPrice());
        Assertions.assertEquals(price + 13.0, paper.getPrice());
    }

    @Test
    public void testDescription() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        flower.setSepalLength(10.0);
        RibbonDecorator ribbon = new RibbonDecorator(flower);
        BasketDecorator basket = new BasketDecorator(flower);
        PaperDecorator paper = new PaperDecorator(flower);
        Assertions.assertEquals(flower.getDescription() + "\nWRAPPER: ribbon", ribbon.getDescription());
        Assertions.assertEquals(flower.getDescription() + "\nWRAPPER: basket", basket.getDescription());
        Assertions.assertEquals(flower.getDescription() + "\nWRAPPER: paper", paper.getDescription());
    }
}
