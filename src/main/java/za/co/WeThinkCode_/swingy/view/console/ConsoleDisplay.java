package za.co.WeThinkCode_.swingy.view.console;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;
import za.co.WeThinkCode_.swingy.view.Iview;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Builder
@Getter
@Setter
public class ConsoleDisplay implements Iview {

    private LogicController controller;
    @Builder.Default
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void startMenu() {
        String[] input = {""};

        if (controller.hero == null){
            String[] validInputs = {"1","2","3"};

            while (!(ArrayUtils.contains(validInputs, input[0]))){

                clearScreen();
                printSplash();

                System.out.print(
                        "******************************************************************************\n" +
                                "*                                     MAIN MENU                              *\n" +
                                "*                  1.) New Game    2.) Load Game   3.) Quit                  *\n" +
                                "******************************************************************************\n" +
                                "Please type choice: \n"
                );

                input[0] = scanner.nextLine();

                if (!(ArrayUtils.contains(validInputs, input[0])))
                {
                    System.out.println("\nInvalid choice. Enter either 1, 2, or 3.");
                    try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                }
            }
            controller.handleInput(input);
        } else {
            String[] validInputs = {"1","2","3","4"};

            while (!(ArrayUtils.contains(validInputs, input[0]))){

                clearScreen();
                printSplash();

                System.out.print(
                                "******************************************************************************\n" +
                                "*                                     MAIN MENU                              *\n" +
                                "*                                                                            *\n" +
                                "*                    1.) New Game    2.) Load Game   3.) Quit                *\n" +
                                "*                                                                            *\n" +
                                "*                            4.) Continue The Adventure!                     *\n" +
                                "*                                                                            *\n" +
                                "******************************************************************************\n" +
                                "Please type choice: \n"
                );

                input[0] = scanner.nextLine();

                if (!(ArrayUtils.contains(validInputs, input[0])))
                {
                    System.out.println("\nInvalid choice.");
                    try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                }
            }
            controller.handleInput(input);
        }
    }

    @Override
    public void createCharacterMenu() {
        String[] input = {"",""};
        String[] validInputs = {"1","2","3","4"};
        while (!(ArrayUtils.contains(validInputs, input[0]))){

            clearScreen();
            printSplash();

            System.out.print(
                                "******************************************************************************\n" +
                                "*                            CREATE CHARACTER                                *\n" +
                                "*         1.) WARLOCK    2.) TITAN   3.) HUNTER   4.)QUIT TO MENU            *\n" +
                                "******************************************************************************\n" +
                                "Please type choice: \n"
            );

            input[0] = scanner.nextLine();

            if (!(ArrayUtils.contains(validInputs, input[0])))
            {
                System.out.println("\nInvalid choice(here). Enter either 1, 2, 3 or 4.");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }

        if(input[0].equalsIgnoreCase("4"))
            controller.handleInput(input);
        else{
            while (input[1].isEmpty() || (input[1].length() > 10)){

                clearScreen();
                printSplash();

                System.out.print(
                        "******************************************************************************\n" +
                                "*                            Please type a name                              *\n" +
                                "******************************************************************************\n" +
                                "Type name here: \n"
                );

                input[1] = scanner.nextLine();

                if (input[1].isEmpty() || (input[1].length() > 10))
                {
                    System.out.println("\nInvalid choice(can't be empty or longer than 10 characters). Please type a name");
                    try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                }
            }

            controller.handleInput(input);
        }
    }

    @Override
    public void loadCharacterMenu() {
        String[] input = {""};

        File file = new File(controller.getSaveFilePath());

        File[] fileNames = file.listFiles();

        ArrayList<String> validInputs = new ArrayList<String>();

        if (fileNames.length < 1){
            System.out.print(
                            "******************************************************************************\n" +
                            "*                              LOAD CHARACTER                                *\n" +
                            "*                 No Saved Characters. Press enter to go back to menu        *\n" +
                            "******************************************************************************\n"
            );

            scanner.nextLine();
            input[0] = "NO_SAVED_FILES";

        } else {
            for (File fileName : fileNames) {

                validInputs.add(fileName.getName().split("\\.")[0]);

            }
            while (!(validInputs.contains(input[0]))){

                clearScreen();
                printSplash();

                System.out.print(
                                "******************************************************************************\n" +
                                "*                              LOAD CHARACTER                                *\n" +
                                "*                  Please type a name from the list below:                   *\n" +
                                "******************************************************************************\n"
                );

                for (String validInput : validInputs) {
                    System.out.println("*- ".concat(validInput));
                }

                System.out.println("Please type name here: ");

                input[0] = scanner.nextLine();

                if (!(validInputs.contains(input[0])))
                {
                    System.out.println("\nInvalid choice");
                    try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                }
            }
        }
        controller.handleInput(input);
    }

    @Override
    public void moveCharacterScreen() {
        String[] input = {""};
        String[] validInputs = {"1","2","3","4","5"};

        while (!(ArrayUtils.contains(validInputs, input[0]))){

            clearScreen();
            printCharacter();

            System.out.print(
                            "******************************************************************************\n" +
                            "*                                 MOVE CHARACTER                             *\n" +
                            "*                   1.) NORTH  2.) SOUTH  3.) EAST  4.) WEST                 *\n" +
                            "*                                  5.)QUIT TO MENU                           *\n" +
                            "******************************************************************************\n" +
                            "Please type choice: \n"
            );

            input[0] = scanner.nextLine();

            if (!(ArrayUtils.contains(validInputs, input[0])))
            {
                System.out.println("\nInvalid choice. Try again");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }
        controller.handleInput(input);
    }

    @Override
    public void fightScreen() {
        String[] input = {""};
        String[] validInputs = {"1","2"};

        while (!(ArrayUtils.contains(validInputs, input[0]))){

            clearScreen();
            printCharacter();

            System.out.print(
                    "******************************************************************************\n" +
                    "*                          YOU HAVE ENCOUNTERED A RABID ENEMY!               *\n" +
                    "*                              1.) FIGHT  2.) TRY RUN                        *\n" +
                    "******************************************************************************\n" +
                    "Please type choice: \n"
            );

            input[0] = scanner.nextLine();

            if (!(ArrayUtils.contains(validInputs, input[0])))
            {
                System.out.println("\nInvalid choice. Try again");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }
        controller.handleInput(input);
    }

    @Override
    public void fightWonScreen() {
        clearScreen();
        printCharacter();

        System.out.print(
                "******************************************************************************\n" +
                "*                                YOU WON THE FIGHT!                          *\n" +
                "*                              press enter to continue                       *\n" +
                "******************************************************************************\n"
        );

        scanner.nextLine();
        controller.handleInput(new String[]{""});
    }

    @Override
    public void fightWonDroppedItemScreen() {
        String[] input = {"",""};
        String[] validInputs = {"1","2"};

        Legendary item = controller.hero.randomItem();

        if (controller.hero.getItem() == item){
            System.out.print(
                            "******************************************************************************\n" +
                            "*                               YOU WON THE FIGHT!                           *\n" +
                            "*                          THE ENEMY DROPPED A DAMN DUPE!                    *\n" +
                            "*                             press enter to continue                        *\n" +
                            "******************************************************************************\n"
            );
            scanner.nextLine();
            controller.handleInput(new String[]{"2"});
        } else {
            int atk = (controller.hero.getItem().getAtk() - item.getAtk());
            int def = (controller.hero.getItem().getDef() - item.getDef());

            String atkSymbol = (atk > 0)? "-" : "+";
            String defSymbol = (def > 0)? "-" : "+";

            if(atk < 0) atk *= -1;

            if(def < 0) def *= -1;

            while (!(ArrayUtils.contains(validInputs, input[0]))){

                clearScreen();
                printCharacter();

                System.out.print(
                        "******************************************************************************\n" +
                                "*                               YOU WON THE FIGHT!                           *\n" +
                                "*                               THE ENEMY DROPPED                            *\n" +
                                "* Name : " + item.getClass().getSimpleName() + "\n" +
                                "* ATK  : " + atkSymbol + atk + "\n" +
                                "* DEF  : " + defSymbol + def + "\n" +
                                "*                                  KEEP IT?                                  *\n" +
                                "*                  1.) YES                         2.) NO                    *\n" +
                                "******************************************************************************\n" +
                                "Please type choice: \n"
                );

                input[0] = scanner.nextLine();
                input[1] = item.getClass().getSimpleName();

                if (!(ArrayUtils.contains(validInputs, input[0])))
                {
                    System.out.println("\nInvalid choice.");
                    try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
                }
            }
            controller.handleInput(input);
        }
    }

    @Override
    public void fightLostScreen() {
        clearScreen();
        printCharacter();

        System.out.print(
                "******************************************************************************\n" +
                "*                                YOU LOST THE FIGHT....                      *\n" +
                "*                            press enter to go back to menu                  *\n" +
                "******************************************************************************\n"
        );

        scanner.nextLine();
        controller.handleInput(new String[]{""});
    }

    @Override
    public void ranAway() {

        clearScreen();
        printCharacter();

        System.out.print(
                        "******************************************************************************\n" +
                        "*                                YOU MANAGED TO RUN!                         *\n" +
                        "*                              press enter to continue                       *\n" +
                        "******************************************************************************\n"
        );

        scanner.nextLine();
    }

    @Override
    public void ranNotAway() {
        clearScreen();
        printCharacter();

        System.out.print(
                "******************************************************************************\n" +
                "*                                YOU FAILED TO RUN...                        *\n" +
                "*                              press enter to fight!                         *\n" +
                "******************************************************************************\n"
        );

        scanner.nextLine();
    }

    @Override
    public void endRound() {
        clearScreen();
        printCharacter();

        System.out.print(
                        "******************************************************************************\n" +
                        "*                              YOU CLEARED THE STAGE!                        *\n" +
                        "*                             press enter to continue                        *\n" +
                        "******************************************************************************\n"
        );

        scanner.nextLine();
        controller.handleInput(new String[]{""});
    }

    @Override
    public void endRoundDing() {
        clearScreen();
        printCharacter();

        System.out.print(
                        "******************************************************************************\n" +
                        "*                     YOU CLEARED THE STAGE AND LEVELED UP!!!!!              *\n" +
                        "*                            You have reached level -"+ controller.hero.getLevel() +"-                      *\n" +
                        "*                             press enter to continue                        *\n" +
                        "******************************************************************************\n"
        );

        scanner.nextLine();
        controller.handleInput(new String[]{""});
    }

    @Override
    public void quitVerify() {
        String[] input = {""};
        String[] validInputs = {"1","2"};

        while (!(ArrayUtils.contains(validInputs, input[0]))){

            clearScreen();
            printSplash();

            System.out.print(
                    "******************************************************************************\n" +
                    "*                          Sure you want to quit?                            *\n" +
                    "*                  1.) YES                         2.) NO                    *\n" +
                    "******************************************************************************\n" +
                    "Please type choice: \n"
            );

            input[0] = scanner.nextLine();

            if (!(ArrayUtils.contains(validInputs, input[0])))
            {
                System.out.println("\nInvalid choice. Enter either 1, 2.");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }
        controller.handleInput(input);
    }

    @Override
    public void quit() {
        String input = "";

        clearScreen();
        printSplash();

        String[] credits = {
                " Executive Producer",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Executive Director",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Executive Janitor",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Senior Developer",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Junior Developer's",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Hero Wrangler",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                " Legendary Drool remover",
                "\n",
                "           Ryan Hutchinson",
                "\n",
                "\n",
                "\n",
                "  SPECIAL THANKS TO MY GOOD FRIEND JULIAN WOLF FOR THE FOLLOWING CONTRIBUTIONS:\n",
                "\n",
                "                           Nothing as of yet",
                "\n",
                "\n",
                "                                 8====D",
                "\n",
                "\n"
        };

        System.out.print(
                        "******************************************************************************\n" +
                        "*                                                                            *\n" +
                        "*                              Thanks for playing!                           *\n" +
                        "*                                                                            *\n" +
                        "******************************************************************************\n"
        );
        System.out.println(
                        " CREDITS:\n"
        );
        for(int i = 0; i < credits.length; i++){
            try { Thread.sleep(250);} catch (InterruptedException ex) {ex.printStackTrace();}
            System.out.print(credits[i]);
        }
        clearScreen();
    }

    public static void clearScreen(){

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}


    }

    private void printSplash(){
        System.out.print(
                "******************************************************************************\n" +
                "*                                                                             *\n" +
                "*                      /  ___|| |  | |_   _| \\ | |  __ \\ \\ / /                *\n" +
                "*                      \\ `--. | |  | | | | |  \\| | |  \\/\\ V /                 *\n" +
                "*                       `--. \\| |/\\| | | | | . ` | | __  \\ /                  *\n" +
                "*                     /\\__/ /\\  \\/\\  /_| |_| |\\  | |_\\ \\ | |                  *\n" +
                "*                      \\____/  \\/  \\/ \\___/\\_| \\_/\\____/ \\_/                  *\n" +
                "*                                                                             *\n" +
                "*******************************************************************************\n"
        );
    }

    private void printCharacter(){

        System.out.print(
                        "******************************************************************************\n" +
                        "* " + controller.hero.getName() + "\n" +
                        "* Class  : " + controller.hero.getClass().getSimpleName() + "\n" +
                        "* Level  : " + controller.hero.getLevel() + "\n" +
                        "* EXP    : " + controller.hero.getExp() + "\n" +
                        "* Item   : " + controller.hero.getItem().getClass().getSimpleName() + "\n" +
                        "*\n" +
                        "* ATK    : " + (controller.hero.getItem().getAtk() + controller.hero.getAtk()) + "\n" +
                        "* DEF    : " + (controller.hero.getItem().getDef() + controller.hero.getDef()) + "\n" +
                        "*\n" +
                        "* HP     : " + (controller.hero.getHp()) + "\n" +
                        "******************************************************************************\n"
        );
    }

}
