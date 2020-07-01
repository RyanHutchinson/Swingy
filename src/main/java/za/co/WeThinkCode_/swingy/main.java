package za.co.WeThinkCode_.swingy;


import za.co.WeThinkCode_.swingy.model.enemy.Cabal;
import za.co.WeThinkCode_.swingy.model.player.Hero;
import za.co.WeThinkCode_.swingy.model.player.Warlock;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Cabal enemy = Cabal.builder().build();
        Warlock player = Warlock.builder()
                                        .level(1)
                                        .name("me")
                                        .build();

        try {
            if (player.fight(enemy)){
                System.out.println("You won the fight!");
            } else {
                System.out.println("You lost the fight!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
