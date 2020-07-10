package za.co.WeThinkCode_.swingy.view.gui;

import lombok.Builder;
import lombok.Getter;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.view.Iview;

import javax.swing.*;
import java.awt.*;

@Builder
@Getter
public class GuiDisplay implements Iview {

    public static JFrame frame = new JFrame();
    private LogicController controller;

    @Override
    public void startMenu() {
        MainMenu generate = MainMenu.builder().controller(controller).frame(frame).build();
        makeWindow();
        generate.view();
    }

    @Override
    public void createCharacterMenu() {

    }

    @Override
    public void loadCharacterMenu() {

    }

    @Override
    public void moveCharacterScreen() {

    }

    @Override
    public void fightScreen() {

    }

    @Override
    public void fightWonDroppedItemScreen() {

    }

    @Override
    public void fightWonScreen() {

    }

    @Override
    public void fightLostScreen() {

    }

    @Override
    public void ranAway() {

    }

    @Override
    public void ranNotAway() {

    }

    @Override
    public void endRound() {

    }

    @Override
    public void endRoundDing() {

    }

    @Override
    public void quitVerify() {
        QuitVerify generate = QuitVerify.builder().controller(controller).frame(frame).build();
        makeWindow();
        generate.view();
    }

    @Override
    public void quit() {

    }

    public static void makeWindow(){
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
