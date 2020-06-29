package za.co.WeThinkCode_.swingy;

import za.co.WeThinkCode_.swingy.control.Controller;

import javax.naming.ldap.Control;

public class main{
    public static void main(String[] args) {
        Controller GameControl;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("-console") || args[0].equalsIgnoreCase("-gui")) {
                GameControl = new Controller(args[0]);
                GameControl.whatIsView();
            } else {
                System.out.println("Invalid command.\nPlease use a valid flag: [-gui , -console]");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid command.\nPlease use a valid flag: [-gui , -console]");
            System.exit(0);
        }
    }
}
