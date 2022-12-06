package com.example.demoFlowerStore.flower.store;

public enum FlowerType {
    CHAMOMILE("CHAMOMILE"), ROSE("ROSE"), TULIP("TULIP"), DEFAULT("FLOWER");
    private final String stringRepresentation;
    FlowerType(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }
    @Override
    public String toString() {
        return stringRepresentation;
    }
}
