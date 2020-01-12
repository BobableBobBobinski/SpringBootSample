package com.cko.sampleSpringProject.model;

public enum CardsRank {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);

    private final int value;

    CardsRank(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}