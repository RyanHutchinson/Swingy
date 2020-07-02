package za.co.WeThinkCode_.swingy.view.console;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.view.Iview;
import java.io.IOException;
import java.util.Scanner;

@Builder
@Getter
@Setter
public class ConsoleDisplay implements Iview {

    private LogicController controller;
    @Builder.Default
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void say(String say) {
        System.out.println(say);
    }

    @Override
    public void startMenu() {
        String input = "";

        while (!(input.equalsIgnoreCase("1")) && !(input.equalsIgnoreCase("2")) && !(input.equalsIgnoreCase("3"))){

            clearScreen();
            printSplash();

            System.out.print(
                "1.) New Game\n2.) Load Game\n3.) Quit\n\n" +
                "Please type choice: \n"
                );

            input = scanner.nextLine();

            if (!(input.equals("1") || input.equals("2") || input.equals("3")))
            {
                System.out.println("\nInvalid choice. Enter either 1, 2, or 3.");
                try { Thread.sleep(1000);} catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }
        controller.handleInput(input);

    }

    @Override
    public void quitVerify() {
        String input = "";

        while (!(input.equalsIgnoreCase("1")) && !(input.equalsIgnoreCase("2")) && !(input.equalsIgnoreCase("3"))){

            clearScreen();
            printSplash();

            System.out.print(
                    "******************************************************************************\n" +
                    "*                          Sure you want to quit?                            *\n" +
                    "*                  1.) YES                         2.) NO                    *\n" +
                    "******************************************************************************\n" +
                    "Please type choice: \n"
            );

            input = scanner.nextLine();

            if (!(input.equals("1") || input.equals("2") || input.equals("3")))
            {
                System.out.println("\nInvalid choice. Enter either 1, 2, or 3.");
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

}
