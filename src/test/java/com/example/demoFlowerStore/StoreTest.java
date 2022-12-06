package com.example.demoFlowerStore;

import com.example.demoFlowerStore.flower.store.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StoreTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Tulip tul;
    private Rose rose;
    private Chamomile chamo;
    private Store s;
    private FlowerBucket bucket1;
    private FlowerBucket bucket2;
    private FlowerBucket bucket3;

    private FlowerPack p1;
    private FlowerPack p2;
    private FlowerPack p3;

    @BeforeEach
    public void init() {

        tul = new Tulip();
        chamo = new Chamomile();
        rose = new Rose();
        s = new Store();
        bucket1 = new FlowerBucket();
        bucket2 = new FlowerBucket();
        bucket3 = new FlowerBucket();
        p1 = new FlowerPack(tul, 10);
        p2 = new FlowerPack(rose, 15);
        p3 = new FlowerPack(chamo, 50);
    }

    @Test
    public void testSearch() {

//        Random RANDOM_GENERATOR = new Random();
//        int MAX_PRICE = 100;
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);

        Tulip tul = new Tulip();
        Chamomile chamo = new Chamomile();
        Rose rose = new Rose();

        tul.setPrice(price);
        tul.setColor(FlowerColor.YELLOW);

        rose.setPrice(price);
        rose.setColor(FlowerColor.RED);

        chamo.setPrice(price);
        chamo.setColor(FlowerColor.WHITE);

//        Store s = new Store();
//        FlowerBucket bucket1 = new FlowerBucket();
//        FlowerBucket bucket2 = new FlowerBucket();
//        FlowerBucket bucket3 = new FlowerBucket();
//        FlowerPack p1 = new FlowerPack(tul, 10);
//        FlowerPack p2 = new FlowerPack(rose, 15);
//        FlowerPack p3 = new FlowerPack(chamo, 50);

        p1 = new FlowerPack(tul, 10);
        p2 = new FlowerPack(rose, 15);
        p3 = new FlowerPack(chamo, 50);

        bucket1.add(p1);
        bucket1.add(p2);
        bucket2.add(p2);
        bucket2.add(p1);
        bucket2.add(p3);
        bucket3.add(p3);
        bucket3.add(p2);

        s.addBucket(bucket1);
        s.addBucket(bucket2);
        s.addBucket(bucket3);

        Assertions.assertEquals(true, s.search(bucket1));
        Assertions.assertEquals(true, s.search(bucket2));
        Assertions.assertEquals(true, s.search(bucket3));
        Assertions.assertEquals(false, s.search(bucket1));
        Assertions.assertEquals(false, s.search(bucket2));
        Assertions.assertEquals(false, s.search(bucket3));
    }
}
