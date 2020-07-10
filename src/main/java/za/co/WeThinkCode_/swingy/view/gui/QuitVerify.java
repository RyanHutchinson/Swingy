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
public class QuitVerify {

    private final LogicController controller;
    private final JFrame frame;

    private JPanel  splashPanel,
                    messagePanel,
                    buttonPanel;

    private JLabel  title,
                    message;

    private JButton accept,
                    reject;

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

        messagePanel = new JPanel();
        messagePanel.setBounds(100,260,600, 50);
        messagePanel.setBackground(Color.darkGray);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 320,200, 200);
        buttonPanel.setBackground(Color.darkGray);

    }

    private void generateLabels(){
        title = new JLabel();
        title.setText("Swingy");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Ariel",Font.PLAIN,80));

        message = new JLabel();
        message.setText("Are you sure you want to quit?");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Ariel",Font.PLAIN,20));
    }

    private void generateButtons(){

    /**************************************************************************
     Confirm Button
     ***************************************************************************/
        accept = new JButton();
        accept.setText("YES");
        accept.setFont(new Font("Ariel",Font.PLAIN,20));
        accept.setBackground(Color.DARK_GRAY);
        accept.setForeground(Color.WHITE);
        accept.setBounds(350,300,0,50);

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                messagePanel.setVisible(false);
                buttonPanel.setVisible(false);
                controller.handleInput(new String[]{"1"});
            }
        });

    /**************************************************************************
     REJECT BUTTON
     ***************************************************************************/
        reject = new JButton();
        reject.setText("NO");
        reject.setFont(new Font("Ariel",Font.PLAIN,20));
        reject.setBackground(Color.DARK_GRAY);
        reject.setForeground(Color.WHITE);
        reject.setBounds(410,300,0,50);

        reject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashPanel.setVisible(false);
                buttonPanel.setVisible(false);
                messagePanel.setVisible(false);
                controller.handleInput(new String[]{"2"});
            }
        });
    }

    private void populatePanels(){
        splashPanel.add(title);
        messagePanel.add(message);

        buttonPanel.add(accept);
        buttonPanel.add(reject);

        frame.getContentPane().add(splashPanel);
        frame.getContentPane().add(messagePanel);
        frame.getContentPane().add(buttonPanel);
    }

}
