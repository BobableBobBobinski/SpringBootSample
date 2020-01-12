package com.cko.sampleSpringProject.model;

public enum CardsSuit {
    DIAMONDS(5), CLUBS(10), HEARTS(15), SPADES(20);

    private final int value;

    CardsSuit(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}