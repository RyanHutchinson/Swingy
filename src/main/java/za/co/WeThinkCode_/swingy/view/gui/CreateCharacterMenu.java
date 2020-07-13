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
public class CreateCharacterMenu {

    private final LogicController   controller;
    private final JFrame            frame;

    private JLabel                  title,
                                    message1,
                                    message2;

    private JPanel                  splashPanel,
                                    messagePanel,
                                    nameMessagePanel,
                                    buttonPanel,
                                    exitButtonPanel;

    private JTextArea               name;

    private JButton                 okButton,
                                    exitGameBButton;

    private JRadioButton            Warlock,
                                    Hunter,
                                    Titan;

    private ButtonGroup             choice;

    public void view(){
        generatePanels();
        generateLabels();
        generateTextAreas();
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

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 270,400, 100);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(new GridLayout(3,1));

        nameMessagePanel = new JPanel();
        nameMessagePanel.setBounds(300,370,200, 100);
        nameMessagePanel.setBackground(Color.darkGray);
        nameMessagePanel.setLayout(new GridLayout(3,1));

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

        message2 = new JLabel();
        message2.setText("Type Name:");
        message2.setForeground(Color.WHITE);
        message2.setFont(new Font("Ariel",Font.PLAIN,15));
    }

    private void generateTextAreas(){
        name = new JTextArea();
    }

    private void generateButtons(){

        /**************************************************************************
         * WARLOCK BUTTON
         ***************************************************************************/
        Warlock = new JRadioButton();
        Warlock.setText("Warlock");
        Warlock.setFont(new Font("Ariel",Font.PLAIN,20));
        Warlock.setBackground(Color.DARK_GRAY);
        Warlock.setForeground(Color.WHITE);
        Warlock.setSelected(true);

        /**************************************************************************
         * TITAN BUTTON
        ***************************************************************************/
        Titan = new JRadioButton();
        Titan.setText("Titan");
        Titan.setFont(new Font("Ariel",Font.PLAIN,20));
        Titan.setBackground(Color.DARK_GRAY);
        Titan.setForeground(Color.WHITE);

        /**************************************************************************
         * HUNTER BUTTON
         ***************************************************************************/
        Hunter = new JRadioButton();
        Hunter.setText("Hunter");
        Hunter.setFont(new Font("Ariel",Font.PLAIN,20));
        Hunter.setBackground(Color.DARK_GRAY);
        Hunter.setForeground(Color.WHITE);

        /**************************************************************************
         * OK BUTTON
         ***************************************************************************/
        okButton = new JButton();
        okButton.setText("OK");
        okButton.setFont(new Font("Ariel",Font.PLAIN,20));
        okButton.setBackground(Color.DARK_GRAY);
        okButton.setForeground(Color.WHITE);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Warlock.isSelected())
                    controller.handleInput(new String[]{"1",name.getText()});
                else if (Titan.isSelected())
                    controller.handleInput(new String[]{"2",name.getText()});
                else
                    controller.handleInput(new String[]{"3",name.getText()});
                clearPanels();
            }
        });

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
                controller.handleInput(new String[]{"4"});
            }
        });
    }

    private void populatePanels(){
        splashPanel.add(title);

        messagePanel.add(message1);

        buttonPanel.add(Warlock);
        buttonPanel.add(Titan);
        buttonPanel.add(Hunter);

        nameMessagePanel.add(message2);
        nameMessagePanel.add(name);
        nameMessagePanel.add(okButton);
        exitButtonPanel.add(exitGameBButton);

        frame.getContentPane().add(splashPanel);
        frame.getContentPane().add(messagePanel);
        frame.getContentPane().add(buttonPanel);
        frame.getContentPane().add(nameMessagePanel);
        frame.getContentPane().add(exitButtonPanel);
        frame.validate();
    }

    private void setupButtonGroups(){
        choice = new ButtonGroup();
        choice.add(Warlock);
        choice.add(Hunter);
        choice.add(Titan);
    }

    private void clearPanels(){
        splashPanel.setVisible(false);
        buttonPanel.setVisible(false);
        messagePanel.setVisible(false);
        nameMessagePanel.setVisible(false);
        exitButtonPanel.setVisible(false);
    }
}
