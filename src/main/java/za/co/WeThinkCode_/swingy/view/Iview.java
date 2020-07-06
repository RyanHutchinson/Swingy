package za.co.WeThinkCode_.swingy.view;

import lombok.Setter;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.player.Hero;


public interface Iview {

    public abstract void say(String say);
    public abstract void startMenu();
    public abstract void createCharacterMenu();
    public abstract void moveCharacterScreen();
    public abstract void fightScreen();
    public abstract void fightWonScreen();
    public abstract void fightLostScreen();
    public abstract void ranAway();
    public abstract void ranNotAway();
    public abstract void endRound();
    public abstract void endRoundDing();
    public abstract void quitVerify();
    public abstract void quit();

}
