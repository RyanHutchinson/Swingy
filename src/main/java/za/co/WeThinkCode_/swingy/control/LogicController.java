package za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.model.player.Hero;
import za.co.WeThinkCode_.swingy.view.Iview;
import za.co.WeThinkCode_.swingy.view.console.ConsoleDisplay;

import java.util.Scanner;

@Getter
@Setter
@Builder
public class LogicController {

    public String gameView;
    public enum Stage{MAIN_MENU, NEW_CHARACTER_MENU, LOAD_CHARACTER_MENU, PLAY_MOVE, PLAY_TRY_RUN, PLAY_FIGHT, GAME_OVER, QUIT_VERIFY, QUIT};
    @Builder.Default
    private Stage gameStage = Stage.MAIN_MENU;
    private Iview view;

    public Hero hero;

    public void runGame(){

        Scanner scanner = new Scanner(System.in);
        if(gameView.equalsIgnoreCase("-console")){
            view = ConsoleDisplay.builder().controller(this).build();
        } else {
            //TODO: guibuilder
        }

        while (true){

            switch (gameStage){
                case MAIN_MENU:
                    view.startMenu();
                    break;
                case PLAY_MOVE:
                    gameStage = Stage.GAME_OVER;
                    break;
                case GAME_OVER:
                    gameStage = Stage.QUIT;
                    break;
                case QUIT_VERIFY:
                    view.quitVerify();
                    break;
                case QUIT:
                    view.quit();
                    System.exit(1);
            }
        }
    }

    public void handleInput(String input){
        switch (gameStage){

            case MAIN_MENU:
                switch (input){
                    case "1": //New Game
                        //TODO
                        break;
                    case "2": //Load Game
                        //TODO
                        break;
                    case "3": //Quit
                        gameStage = Stage.QUIT_VERIFY;
                        break;
                    default:
                        System.out.println("Something went terribly wrong");
                        System.exit(-1);
                }
                break;

            case PLAY_MOVE:
                //TODO
                break;

            case GAME_OVER:
                //TODO
                break;

            case QUIT_VERIFY:
                switch (input){
                    case "1":
                        gameStage = Stage.QUIT;
                        break;
                    case "2":
                        gameStage = Stage.MAIN_MENU;
                        break;
                    default:
                        System.out.println("Something went terribly wrong");
                        System.exit(-1);
                }
                break;
        }
    }
}
