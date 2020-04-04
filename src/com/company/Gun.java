package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Gun {
    private int power;

    Gun() {
        this.power = ThreadLocalRandom.current().nextInt(30, 100);
    }

    public int getPower() {
        return this.power;
    }
}