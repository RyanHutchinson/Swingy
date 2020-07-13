package za.co.WeThinkCode_.swingy.view.gui;

import lombok.Builder;
import lombok.Getter;
import za.co.WeThinkCode_.swingy.control.LogicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Builder
@Getter
public class MoveCharacterScreen {

    private final LogicController   controller;
    private final JFrame            frame;

    private JPanel                  characterPanel,
                                    messagePanel,
                                    buttonPanel,
                                    exitButtonPanel;

    private JLabel                  message;

    private JTextArea               characterStats;

    private JButton                 moveNorthBTN,
                                    moveSouthBTN,
                                    moveEastBTN,
                                    moveWestBTN,
                                    exitGame;

    public void view(){
        generatePanels();
        generateLabels();
        generateTextAreas();
        generateButtons();
        populatePanels();
    }

    private void generatePanels(){
        characterPanel = new JPanel();
        characterPanel.setBounds(250,10,300, 250);
        characterPanel.setBackground(Color.darkGray);
        characterPanel.setVisible(true);

        messagePanel = new JPanel();
        messagePanel.setBounds(100,280,600, 50);
        messagePanel.setBackground(Color.darkGray);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 330,200, 100);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setVisible(true);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(350, 500,100, 50);
        exitButtonPanel.setBackground(Color.darkGray);
    }

    private void generateLabels(){
        message = new JLabel();
        message.setText("Please choose a direction to move");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Ariel",Font.PLAIN,20));

    }

    private void generateTextAreas(){
        characterStats = new JTextArea(
                        "--> " +controller.hero.getName() + " <--\n" +
                        "Class  : " + controller.hero.getClass().getSimpleName() + "\n" +
                        "Level  : " + controller.hero.getLevel() + "\n" +
                        "EXP    : " + controller.hero.getExp() + "\n" +
                        "Item   : " + controller.hero.getItem().getClass().getSimpleName() + "\n\n" +
                        "ATK    : " + (controller.hero.getItem().getAtk() + controller.hero.getAtk()) + "\n" +
                        "DEF    : " + (controller.hero.getItem().getDef() + controller.hero.getDef()) + "\n\n" +
                        "HP     : " + (controller.hero.getHp())
        );

        characterStats.setBackground(Color.darkGray);
        characterStats.setForeground(Color.WHITE);
        characterStats.setFont(new Font("Ariel",Font.PLAIN,18));

    }

    private void generateButtons(){

        /**************************************************************************
         NORTH BUTTON
         ***************************************************************************/
        moveNorthBTN = new JButton();
        moveNorthBTN.setText("North");
        moveNorthBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        moveNorthBTN.setBackground(Color.DARK_GRAY);
        moveNorthBTN.setForeground(Color.WHITE);

        moveNorthBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
                controller.handleInput(new String[]{"1"});
            }
        });

        /**************************************************************************
         SOUTH BUTTON
         ***************************************************************************/
        moveSouthBTN = new JButton();
        moveSouthBTN.setText("South");
        moveSouthBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        moveSouthBTN.setBackground(Color.DARK_GRAY);
        moveSouthBTN.setForeground(Color.WHITE);

        moveSouthBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
                controller.handleInput(new String[]{"2"});
            }
        });

        /**************************************************************************
         EAST BUTTON
         ***************************************************************************/
        moveEastBTN = new JButton();
        moveEastBTN.setText("East");
        moveEastBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        moveEastBTN.setBackground(Color.DARK_GRAY);
        moveEastBTN.setForeground(Color.WHITE);

        moveEastBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
                controller.handleInput(new String[]{"3"});
            }
        });

        /**************************************************************************
         WEST BUTTON
         ***************************************************************************/
        moveWestBTN = new JButton();
        moveWestBTN.setText("West");
        moveWestBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        moveWestBTN.setBackground(Color.DARK_GRAY);
        moveWestBTN.setForeground(Color.WHITE);

        moveWestBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
                controller.handleInput(new String[]{"4"});
            }
        });

        /**************************************************************************
         EXIT BUTTON
         ***************************************************************************/
        exitGame = new JButton();
        exitGame.setText("Exit");
        exitGame.setFont(new Font("Ariel",Font.PLAIN,20));
        exitGame.setBackground(Color.DARK_GRAY);
        exitGame.setForeground(Color.WHITE);

        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput(new String[]{"5"});
                clearPanels();
            }
        });

    }

    private void populatePanels(){
        characterPanel.add(characterStats);
        messagePanel.add(message);

        buttonPanel.add(moveNorthBTN);
        buttonPanel.add(moveSouthBTN);
        buttonPanel.add(moveEastBTN);
        buttonPanel.add(moveWestBTN);

        exitButtonPanel.add(exitGame);

        frame.getContentPane().add(characterPanel);
        frame.getContentPane().add(messagePanel);
        frame.getContentPane().add(buttonPanel);
        frame.getContentPane().add(exitButtonPanel);
        frame.validate();
    }

    void clearPanels(){
        characterPanel.setVisible(false);
        messagePanel.setVisible(false);
        buttonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);
    }
}
