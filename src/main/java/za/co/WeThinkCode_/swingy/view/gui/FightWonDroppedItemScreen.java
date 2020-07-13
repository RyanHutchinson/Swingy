package za.co.WeThinkCode_.swingy.view.gui;

import lombok.Builder;
import lombok.Getter;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Builder
@Getter
public class FightWonDroppedItemScreen {

    private final LogicController   controller;
    private final JFrame            frame;
    private Legendary               droppedItem;

    private JPanel                  characterPanel,
                                    messagePanel,
                                    buttonPanel;

    private JTextArea               characterStats,
                                    message;

    private JButton                 keepBTN,
                                    tossBTN;

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
        messagePanel.setBounds(100,280,600, 150);
        messagePanel.setBackground(Color.darkGray);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 430,200, 50);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.setVisible(true);
    }

    private void generateLabels(){

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

        message = new JTextArea();
        //Custom message setup Jebus excuse this mess
        droppedItem = controller.hero.randomItem();
        int atk = (controller.hero.getItem().getAtk() - droppedItem.getAtk());
        int def = (controller.hero.getItem().getDef() - droppedItem.getDef());
        String atkSymbol = (atk > 0)? "-" : "+";
        String defSymbol = (def > 0)? "-" : "+";
        if(atk < 0) atk *= -1;
        if(def < 0) def *= -1;
        //------------------------------------------
        message.setText(
                        "You won the fight!\n" +
                        "The enemy dropped:\n\n" +
                        "Name : " + droppedItem.getClass().getSimpleName() + "\n" +
                        "ATK  : " + atkSymbol + atk + "\n" +
                        "DEF  : " + defSymbol + def + "\n"
        );
        message.setBackground(Color.darkGray);
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Ariel",Font.PLAIN,15));

    }

    private void generateButtons(){

        /**************************************************************************
         KEEP BUTTON
         ***************************************************************************/
        keepBTN = new JButton();
        keepBTN.setText("KEEP");
        keepBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        keepBTN.setBackground(Color.DARK_GRAY);
        keepBTN.setForeground(Color.WHITE);

        keepBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(droppedItem.getClass().getSimpleName());
                controller.handleInput(new String[]{"1",droppedItem.getClass().getSimpleName()});
                clearPanels();
            }
        });

        /**************************************************************************
         TOSS BUTTON
         ***************************************************************************/
        tossBTN = new JButton();
        tossBTN.setText("TOSS");
        tossBTN.setFont(new Font("Ariel",Font.PLAIN,20));
        tossBTN.setBackground(Color.DARK_GRAY);
        tossBTN.setForeground(Color.WHITE);

        tossBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleInput(new String[]{"2"});
                clearPanels();
            }
        });
    }

    private void populatePanels(){
        characterPanel.add(characterStats);
        messagePanel.add(message);

        buttonPanel.add(keepBTN);
        buttonPanel.add(tossBTN);

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
