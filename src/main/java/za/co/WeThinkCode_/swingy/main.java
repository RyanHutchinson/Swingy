package za.co.WeThinkCode_.swingy;

import za.co.WeThinkCode_.swingy.control.LogicController;

public class main {

    public static void main(String[] args) {

        if (args.length != 1){
            System.out.println("Incorrect usage: swingy[-console , -gui]");
        } else if (!(args[0].equalsIgnoreCase("-gui")) && !(args[0].equalsIgnoreCase("-console"))){
            System.out.println("Incorrect usage: swingy[-console , -gui]");
        } else {
            LogicController game = LogicController.builder()
                            .gameView(args[0])
                            .build();

            game.runGame();

        }
    }
}
