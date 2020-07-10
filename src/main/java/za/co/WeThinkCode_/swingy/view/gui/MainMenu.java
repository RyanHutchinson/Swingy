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
public class MainMenu {

    private final LogicController controller;
    private final JFrame frame;

    private JPanel  splashPanel,
                    buttonPanel;

    private JLabel title;

    private JButton newCharacter,
                    loadCharacter,
                    exitGame,
                    continueGame;

    public void view(){
        generatePanels();
        generateLabels();
        generateButtons();
        populatePanels();
    }

    private void generatePanels(){
        splashPanel = new JPanel();
        splashPanel.setBounds(100,100,600, 150);
        splashPanel.setBackground(Color.darkGray);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 260,200, 340);
        buttonPanel.setBackground(Color.darkGray);

    }

    private void generateLabels(){
        title = new JLabel();
        title.setText("Swingy");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Ariel",Font.PLAIN,80));
    }

    private void generateButtons(){

/**************************************************************************
 NEW CHARACTER BUTTON
 ***************************************************************************/
        newCharacter = new JButton();
        newCharacter.setText("New Game");
        newCharacter.setFont(new Font("Ariel",Font.PLAIN,20));
        newCharacter.setBackground(Color.DARK_GRAY);
        newCharacter.setForeground(Color.WHITE);
        newCharacter.setBounds(0,0,300,50);

        newCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                buttonPanel.setVisible(false);
                controller.handleInput(new String[]{"1"});
            }
        });

/**************************************************************************
 LOAD CHARACTER BUTTON
***************************************************************************/
        loadCharacter = new JButton();
        loadCharacter.setText("Load Game");
        loadCharacter.setFont(new Font("Ariel",Font.PLAIN,20));
        loadCharacter.setBackground(Color.DARK_GRAY);
        loadCharacter.setForeground(Color.WHITE);
        loadCharacter.setBounds(0,0,300,50);

        loadCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                buttonPanel.setVisible(false);
                controller.handleInput(new String[]{"2"});
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
        exitGame.setBounds(0,0,300,50);

        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                buttonPanel.setVisible(false);
                controller.handleInput(new String[]{"3"});
            }
        });

/**************************************************************************
 CONTINUE GAME BUTTON BUTTON
 ***************************************************************************/
        continueGame = new JButton();
        continueGame.setText("Continue Game");
        continueGame.setFont(new Font("Ariel",Font.PLAIN,20));
        continueGame.setBackground(Color.DARK_GRAY);
        continueGame.setForeground(Color.WHITE);
        continueGame.setBounds(0,0,200,50);

        continueGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                buttonPanel.setVisible(false);
                controller.handleInput(new String[]{"4"});
            }
        });
    }

    private void populatePanels(){
        splashPanel.add(title);
        buttonPanel.add(newCharacter);
        buttonPanel.add(loadCharacter);
        buttonPanel.add(exitGame);
        if(controller.hero != null)
            buttonPanel.add(continueGame);
        frame.getContentPane().add(splashPanel);
        frame.getContentPane().add(buttonPanel);
    }

}
