package com.example.demoFlowerStore.flower.store;

public enum FlowerColor {
    /**
     * Flower colors.
     */
    RED("#FF0000"), BLUE("#0000FF"), YELLOW("#FFFF00"), WHITE("#FFFFFF"), NONE("NONE");
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        if (stringRepresentation.equals("#FF0000")) {
            return "RED";
        }
        else if (stringRepresentation.equals("#0000FF")) {
            return "BLUE";
        }
        else if (stringRepresentation.equals("#FFFF00")) {
            return "YELLOW";
        }
        else if (stringRepresentation.equals("#FFFFFF")) {
            return "WHITE";
        }
        return stringRepresentation;
    }
}
