package za.co.WeThinkCode_.swingy.view.gui;

import lombok.Builder;
import lombok.Getter;
import za.co.WeThinkCode_.swingy.control.LogicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@Builder
@Getter
public class LoadCharacterMenu {

    private final LogicController   controller;
    private final JFrame            frame;

    private JLabel                  title,
                                    message1;

    private JPanel                  splashPanel,
                                    messagePanel,
                                    savedFilePanel,
                                    exitButtonPanel;

    private JButton                 exitGameBButton;

    private ButtonGroup             choice;

    public void view(){
        generatePanels();
        generateLabels();
        generateButtons();
        setupButtonGroups();
        populatePanels();
    }

    private void generatePanels(){
        splashPanel = new JPanel();
        splashPanel.setBounds(100,100,600, 110);
        splashPanel.setBackground(Color.darkGray);
        splashPanel.setVisible(true);

        messagePanel = new JPanel();
        messagePanel.setBounds(100,230,600, 50);
        messagePanel.setBackground(Color.darkGray);

        savedFilePanel = new JPanel();
        savedFilePanel.setBounds(300, 280,200, 200);
        savedFilePanel.setBackground(Color.darkGray);
        savedFilePanel.setLayout(new GridLayout(5,1));

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(350, 500,100, 50);
        exitButtonPanel.setBackground(Color.darkGray);
    }

    private void generateLabels(){
        title = new JLabel();
        title.setText("Swingy");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Ariel",Font.PLAIN,80));

        message1 = new JLabel();
        message1.setText("Please choose one of the following:");
        message1.setForeground(Color.WHITE);
        message1.setFont(new Font("Ariel",Font.PLAIN,20));

    }

    private void generateButtons(){
        /**************************************************************************
         * LOADGAME BUTTONS DYNAMIC
         ***************************************************************************/
        setupButtonGroups();
        File file = new File(controller.getSaveFilePath());
        File[] fileNames = file.listFiles();

        if(fileNames.length < 1) {

        } else {
            for (File fileName : fileNames){
                JButton tmp = new JButton();
                tmp.setText(fileName.getName().split("\\.")[0]);
                tmp.setFont(new Font("Ariel",Font.PLAIN,20));
                tmp.setBackground(Color.DARK_GRAY);
                tmp.setForeground(Color.WHITE);
                tmp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.handleInput(new String[]{tmp.getText()});
                        clearPanels();
                    }
                });
                choice.add(tmp);
                savedFilePanel.add(tmp);
            }
        }


        /**************************************************************************
         * EXIT BUTTON
         ***************************************************************************/
        exitGameBButton = new JButton();
        exitGameBButton.setText("Exit");
        exitGameBButton.setFont(new Font("Ariel",Font.PLAIN,20));
        exitGameBButton.setBackground(Color.DARK_GRAY);
        exitGameBButton.setForeground(Color.WHITE);

        exitGameBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanels();
                controller.handleInput(new String[]{"HARD_EXIT"});
            }
        });
    }

    private void populatePanels(){
        splashPanel.add(title);
        messagePanel.add(message1);
        exitButtonPanel.add(exitGameBButton);

        frame.getContentPane().add(splashPanel);
        frame.getContentPane().add(messagePanel);
        frame.getContentPane().add(savedFilePanel);
        frame.getContentPane().add(exitButtonPanel);
        frame.validate();
    }

    private void setupButtonGroups(){
        choice = new ButtonGroup();
    }

    private void clearPanels(){
        splashPanel.setVisible(false);
        savedFilePanel.setVisible(false);
        messagePanel.setVisible(false);
        exitButtonPanel.setVisible(false);
    }
}
