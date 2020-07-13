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
public class RanNotAway {

    private final LogicController   controller;
    private final JFrame            frame;

    private JPanel                  characterPanel,
                                    messagePanel,
                                    buttonPanel;

    private JLabel                  message;

    private JTextArea               characterStats;

    private JButton                 okBTN;

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
        buttonPanel.setBounds(300, 330,200, 220);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setVisible(true);
    }

    private void generateLabels(){
        message = new JLabel();
        message.setText("you didn't manage to run away...");
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
         RUN BUTTON
         ***************************************************************************/
        okBTN = new JButton();
        okBTN.setText("continue");
        okBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        okBTN.setBackground(Color.DARK_GRAY);
        okBTN.setForeground(Color.WHITE);

        okBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
            }
        });
    }

    private void populatePanels(){
        characterPanel.add(characterStats);
        messagePanel.add(message);

        buttonPanel.add(okBTN);

        frame.getContentPane().add(characterPanel);
        frame.getContentPane().add(messagePanel);
        frame.getContentPane().add(buttonPanel);
        frame.validate();
    }

    void clearPanels(){
        characterPanel.setVisible(false);
        messagePanel.setVisible(false);
        buttonPanel.setVisible(false);
    }
}
