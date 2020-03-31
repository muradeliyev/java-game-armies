package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Gun {
    int power;

    Gun() {
        this.power = ThreadLocalRandom.current().nextInt(30, 100);
    }
}