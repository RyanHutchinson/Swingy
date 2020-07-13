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
        StartMenu generate = StartMenu.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void createCharacterMenu() {
        CreateCharacterMenu generate = CreateCharacterMenu.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void loadCharacterMenu() {
        LoadCharacterMenu generate = LoadCharacterMenu.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void moveCharacterScreen() {
        MoveCharacterScreen generate = MoveCharacterScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void fightScreen() {
        FightScreen generate = FightScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void fightWonDroppedItemScreen() {
        FightWonDroppedItemScreen generate = FightWonDroppedItemScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void fightWonScreen() {
        FightWonScreen generate = FightWonScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void fightLostScreen() {
        FightLostScreen generate = FightLostScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void ranAway() {
        RanAway generate = RanAway.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void ranNotAway() {
        RanNotAway generate = RanNotAway.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void endRound() {
        EndRoundScreen generate = EndRoundScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void endRoundDing() {
        EndRoundDingScreen generate = EndRoundDingScreen.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();
        generate.view();
    }

    @Override
    public void quitVerify() {
        QuitVerify generate = QuitVerify.builder()
                .controller(controller)
                .frame(frame)
                .build();

        makeWindow();

        generate.view();
    }

    @Override
    public void quit() {
        //TODO
    }

    public static void makeWindow(){
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
