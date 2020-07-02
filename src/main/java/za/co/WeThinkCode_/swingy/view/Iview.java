package za.co.WeThinkCode_.swingy.view;

import lombok.Setter;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.player.Hero;


public interface Iview {

    public abstract void say(String say);
    public abstract void startMenu();
    public abstract void quitVerify();
    public abstract void quit();

}
