package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Soldier {
    public float health;

    public float power;

    public Gun gun = new Gun();

    public boolean isDead = false;

    Soldier() {
        this.health = (float)ThreadLocalRandom.current().nextInt(100, 500);
        this.power = this.health / 100;
    }

    public void attack(Soldier enemy) {
        enemy.beAttacked(this);
    }

    public void increaseHealth() {
        this.health *= 1.2; // increase soldier's health by 20%
    }

    public void beAttacked(Soldier enemy) {
        this.health -= enemy.power * enemy.gun.power;

        if (this.health <=  0) {
            this.isDead = true;
        }
    }
}