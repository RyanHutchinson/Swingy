package za.co.WeThinkCode_.swingy.model.player;

import org.junit.jupiter.api.Test;
import za.co.WeThinkCode_.swingy.model.enemy.Cabal;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Cabal enemy = Cabal.builder().build();
    Warlock player = Warlock.builder()
            .level(1)
            .name("me")
            .build();

        if (player.fight(enemy)){
            System.out.println("You won the fight!");
        } else {
            System.out.println("You lost the fight!");
        }

    @Test
    void endRound() {
    }

    @Test
    void move() {
    }

    @Test
    void fight() {
    }

    @Test
    void levelUp() {
    }
}