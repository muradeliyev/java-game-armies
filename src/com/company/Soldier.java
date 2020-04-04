package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Soldier {
    private float health;

    private float power;

    private Gun gun = new Gun();

    private boolean isDead = false;

    Soldier() {
        this.health = (float) ThreadLocalRandom.current().nextInt(100, 500);
        this.power = this.health / 100;
    }

    public void attack(Soldier enemy) {
        enemy.beAttacked(this);
    }

    public void increaseHealth() {
        this.health *= 1.2; // increase soldier's health by 20%
    }

    public void beAttacked(Soldier enemy) {
        this.health -= enemy.power * enemy.gun.getPower();

        if (this.health <=  0) {
            this.isDead = true;
        }
    }

    // getters and setters
    public boolean isDead() {
        return this.isDead;
    }

    public float getHealth() {
        return this.health;
    }

}