package com.company;

import java.util.Random;

public class Army {
    private Soldier[] soldiers;

    private boolean lose = false;

    private int dead = 0;
    private int capacity;

    // n represents the number of soldiers in the army
    Army(int n) {
        this.soldiers = new Soldier[n]; // create the soldier array
        this.capacity = n;

        for (int i = 0; i < n; i++) {
            // adding soldiers
            this.soldiers[i] = new Soldier();
        }
    }

    public void attack(Army enemy) {
        enemy.beAttacked(this);
    }

    public void beAttacked(Army enemy) {
        Random rn = new Random();

        for (int j = 0; j < this.soldiers.length; j++) {
            // each soldier will be attacked by 3 random soldiers
            for (int i = 0; i < 3; i++) {
                int who = rn.nextInt(enemy.soldiers.length);

                this.soldiers[j].beAttacked(enemy.soldiers[who]);
            }

            if (this.soldiers[j].isDead()) {
                this.dead++;
                // removing dead soldier
                int length = this.soldiers.length;
                Soldier[] result = new Soldier[length-1];

                for (int k = 0, z = 0; k < length; k++) {
                    if (k != j) {
                        result[z++] = this.soldiers[k];
                    }
                }

                this.soldiers = result;
            }
        }

        if (this.soldiers.length <= 0) {
            this.lose = true;
        }
    }

    public void increaseArmyHealth() {
        for (Soldier soldier : this.soldiers) {
            soldier.increaseHealth();
        }
    }

    public int health() {
        int hp = 0;
        for (int i = 0; i < this.soldiers.length; i++) {
            hp += this.soldiers[i].getHealth();
        }
        return hp;
    }

    public String stats() {
        String stat;
        int alive = this.capacity - this.dead;
        stat = this.health() + "        " + alive + "        " + this.dead;
        return stat;
    }

    // getters and setters
    public boolean isLoser() {
        return this.lose;
    }
}