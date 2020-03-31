package com.company;

import java.util.Scanner;
import java.util.Random;

class Main {
    public static Army myArmy, enemy;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rn = new Random();

    /*
      this is very simple war game between two armies
      one is yours another is enemy
      everytime you given 3 choices either to increase health attack
      or show the stats. if you choose increase health or attacking
      the turn will be changed else it will stay the same.

      enemy will choose the option randomly.

      if you choose increasing health all alive soldiers in your army
      will get extra 20% hp.

      else if you choose attacking all you soldiers will be attacked
      by 3 randomly chosen enemy soldiers
    */

        myArmy = new Army(10);
        enemy = new Army(20);

        boolean turn = true;

        while (true) {
            if (turn) {
                System.out.println("|      your turn       |");
                System.out.println("1. Increase health");
                System.out.println("2. Attack");
                System.out.println("3. Stats");
                int doing = scan.nextInt();
                switch (doing) {
                    case 1:
                        myArmy.increaseArmyHealth();
                        break;
                    case 2:
                        myArmy.attack(enemy);
                        break;
                    case 3:
                        showStats();
                        turn = !turn;
                        break;
                    default:
                        System.out.println("Wrong choise! Enemy's turn!");
                }
            }
            else {
                int doing = rn.nextInt(2);
                switch (doing) {
                    case 0:
                        System.out.println("Enemy chose Attacking!");
                        enemy.attack(myArmy);
                        break;
                    default:
                        System.out.println("Enemy chose Increasing health!");
                        enemy.increaseArmyHealth();
                        break;
                }
            }

            if (myArmy.lose || enemy.lose) break;
            turn = !turn;
        } // end of while loop

        if (myArmy.lose) {
            System.out.println("you lose ;(");
        }
        else {
            System.out.println("you won :)");
        }
    }

    public static void showStats() {
        System.out.println("------------Stats-----------");
        System.out.println("         Health     alive     dead");
        System.out.println("you:      "+myArmy.stats());
        System.out.println("enemy:    "+enemy.stats());
        System.out.println("---------------------------------------------");
    }
}