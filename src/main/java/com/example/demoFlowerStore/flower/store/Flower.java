package com.example.demoFlowerStore.flower.store;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
public class Flower extends Item{
    @Id
    @SequenceGenerator(
            name = "flowers_sequence",
            sequenceName = "flowers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flowers_sequence"
    )

    @Getter
    private Long id;
    @Getter
    private double sepalLength = 0;
    private FlowerColor color = FlowerColor.NONE;
    @Getter
    private double price = 0;
    @Getter
    private FlowerType flowerType = FlowerType.DEFAULT;

    public Flower(){};

    public Flower(double sepalLength, FlowerColor color, double price, FlowerType type, Long id) {

        this.color = color;
        this.sepalLength = sepalLength;
        this.flowerType = type;
        this.price = price;
        this.id = id;
    }

    public Flower(double sepalLength, FlowerColor color, double price, FlowerType type) {

        this.color = color;
        this.sepalLength = sepalLength;
        this.flowerType = type;
        this.price = price;
    }

    public String getColor() {
        return color.toString();
    }

    public String getType() { return flowerType.toString(); }

    public void setId(Long id) {
        this.id = id;
    }

    //    @Override
    public String toString() {
        String name = this.getColor();
        name += " ";
        name += this.getType();
        name += " ";
        name += "PRICE: ";
        name += Double.toString(this.price);
        return name;
    }

    public String getDescription() {
        String name = this.getColor();
        name += " ";
        name += this.getType();
        name += " ";
        name += "PRICE: ";
        name += Double.toString(this.price);
        return name;
    }
}
