package za.co.WeThinkCode_.swingy.control;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.WeThinkCode_.swingy.model.legendary.*;
import za.co.WeThinkCode_.swingy.model.player.Hero;
import za.co.WeThinkCode_.swingy.model.player.Hunter;
import za.co.WeThinkCode_.swingy.model.player.Titan;
import za.co.WeThinkCode_.swingy.model.player.Warlock;
import za.co.WeThinkCode_.swingy.view.Iview;
import za.co.WeThinkCode_.swingy.view.console.ConsoleDisplay;
import za.co.WeThinkCode_.swingy.view.gui.GuiDisplay;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@Getter
@Setter
@Builder
public class LogicController {

    public static enum Stage{
        MAIN_MENU,
        NEW_CHARACTER_MENU,
        LOAD_CHARACTER_MENU,
        PLAY_MOVE,
        FIGHT,
        FIGHT_WON,
        FIGHT_WON_DROPPED_ITEM,
        FIGHT_LOST,
        END_ROUND,
        END_ROUND_DING,
        QUIT_VERIFY,
        QUIT
    };
    @Builder.Default
    String saveFilePath = new File("").getAbsolutePath().concat("\\SaveFiles\\");
    @Builder.Default
    private Boolean notSetup = true;
    private Stage gameStage;
    public String gameView;
    private Iview view;
    public Hero hero;

    public void runGame(){

        if (notSetup){
            view = (gameView.equalsIgnoreCase("-console"))?
                    ConsoleDisplay.builder().controller(this).build() :
                    GuiDisplay.builder().controller(this).build();
            gameStage = Stage.MAIN_MENU;
            notSetup = false;
        }

        switch (gameStage){
            case MAIN_MENU:
                view.startMenu();
                break;

            case NEW_CHARACTER_MENU:
                view.createCharacterMenu();
                break;

            case LOAD_CHARACTER_MENU:
                view.loadCharacterMenu();
                break;

            case PLAY_MOVE:
                view.moveCharacterScreen();
                break;

            case FIGHT:
                view.fightScreen();
                break;

            case FIGHT_WON:
                view.fightWonScreen();
                break;

            case FIGHT_WON_DROPPED_ITEM:
                view.fightWonDroppedItemScreen();
                break;

            case FIGHT_LOST:
                view.fightLostScreen();
                break;

            case END_ROUND:
                view.endRound();
                break;

            case END_ROUND_DING:
                view.endRoundDing();
                break;

            case QUIT_VERIFY:
                view.quitVerify();
                break;

            case QUIT:
                view.quit();
                System.exit(1);
        }
    }

    public void handleInput(String[] input){
        switch (gameStage){

            case MAIN_MENU:
                switch (input[0]){
                    case "1": //New Game
                        gameStage = Stage.NEW_CHARACTER_MENU;
                        break;
                    case "2": //Load Game
                        gameStage = Stage.LOAD_CHARACTER_MENU;
                        break;
                    case "3": //Quit
                        gameStage = Stage.QUIT_VERIFY;
                        break;
                    case "4":
                        gameStage = Stage.PLAY_MOVE;
                        break;
                    default:
                        System.out.println("HandleInput MAIN_MENU Error");
                        System.exit(-1);
                }
                runGame();
                break;

            case NEW_CHARACTER_MENU:
                switch (input[0]){
                    case "1":
                        try {
                            this.hero = Warlock.builder().name(input[1]).build();
                        } catch (NullPointerException e){System.out.println("Woops nullpointer in inputhandler");}
                        saveHero();
                        gameStage = Stage.MAIN_MENU;
                        break;
                    case "2":
                        try {
                            this.hero = Titan.builder().name(input[1]).build();
                        } catch (NullPointerException e){System.out.println("Woops nullpointer in inputhandler");}
                        saveHero();
                        gameStage = Stage.MAIN_MENU;
                        break;
                    case "3":
                        try {
                            this.hero = Hunter.builder().name(input[1]).build();
                        } catch (NullPointerException e){System.out.println("Woops nullpointer in inputhandler");}
                        gameStage = Stage.MAIN_MENU;
                        saveHero();
                        break;
                    case "4":
                        gameStage = Stage.MAIN_MENU;
                        break;
                }
                runGame();
                break;

            case LOAD_CHARACTER_MENU:
                switch (input[0]){
                    case "NO_SAVED_FILES":
                        gameStage = Stage.MAIN_MENU;
                        break;
                    case "HARD_EXIT":
                        gameStage = Stage.MAIN_MENU;
                        break;
                    default:
                        loadHero(input[0]);
                        gameStage = Stage.MAIN_MENU;
                        break;
                }
                runGame();
                break;

            case PLAY_MOVE:
                switch (input[0]){
                    case "5":
                        gameStage = Stage.MAIN_MENU;
                        hero.setCoordinates(new int[]{0,0});
                        break;
                    default:
                        gameStage = hero.move(input[0]);
                        break;
                }
                runGame();
                break;

            case FIGHT:
                switch (input[0]){
                    case "1":
                        gameStage = hero.fight();
                        break;
                    case "2":
                        if (new Random().nextInt(1000) > 700) { //TODO balance
                            view.ranNotAway();
                            gameStage = hero.fight();
                        } else {
                            view.ranAway();
                            gameStage = Stage.PLAY_MOVE;
                        }
                        break;
                }
                runGame();
                break;

            case FIGHT_WON:
                gameStage = Stage.PLAY_MOVE;
                runGame();
                break;

            case FIGHT_WON_DROPPED_ITEM:
                switch (input[0]){
                    case "1":
                        switch (input[1]){
                            case "DubstepGun":
                                hero.setItem(DubstepGun.builder().build());
                                break;
                            case "Izanagis":
                                hero.setItem(Izanagis.builder().build());
                                break;
                            case "LeviathansBreath":
                                hero.setItem(LeviathansBreath.builder().build());
                                break;
                            case "LuckyPants":
                                hero.setItem(LuckyPants.builder().build());
                                break;
                            case "OneEyedMask":
                                hero.setItem(OneEyedMask.builder().build());
                                break;
                            case "TheStag":
                                hero.setItem(TheStag.builder().build());
                                break;
                        }
                        break;
                    case "2":
                        break;
                }
                gameStage = Stage.PLAY_MOVE;
                runGame();
                break;

            case FIGHT_LOST:
                switch (input[0]){
                    case "":
                        hero.endRound();
                        gameStage = Stage.MAIN_MENU;
                        runGame();
                        break;
                    default:
                        System.out.println("Handler Fight_Lost error");
                        break;
                }
                break;

            case END_ROUND_DING:
            case END_ROUND:
                switch (input[0]){
                    case "":
                        saveHero();
                        gameStage = Stage.PLAY_MOVE;
                        break;
                    default:
                        System.out.println("Input Handler END_ROUND Error");
                        break;
                }
                runGame();
                break;

            case QUIT_VERIFY:
                switch (input[0]){
                    case "1":
                        gameStage = Stage.QUIT;
                        break;
                    case "2":
                        gameStage = Stage.MAIN_MENU;
                        break;
                    default:
                        System.out.println("HandleInput QUIT_VERIFY error");
                        System.out.println(input[0]);
                        System.exit(-1);
                }
                runGame();
                break;
        }
    }

    public void saveHero(){

        File file = new File(saveFilePath.concat(hero.getName()).concat(".txt"));

        try {
            FileWriter writer = new FileWriter(file);
            writer.append(
                    hero.getClass().getSimpleName()
                    .concat("\n")
                    .concat(hero.getName())
                    .concat("\n")
                    .concat(Integer.toString(hero.getLevel()))
                    .concat("\n")
                    .concat(Integer.toString(hero.getExp()))
                    .concat("\n")
                    .concat(Integer.toString(hero.getAtk()))
                    .concat("\n")
                    .concat(Integer.toString(hero.getDef()))
                    .concat("\n")
                    .concat(Integer.toString(hero.getHpLevel()))
                    .concat("\n")
                    .concat(hero.getItem().getClass().getSimpleName())
            );
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHero(String name){

        File file = new File(
                saveFilePath
                .concat(name)
                .concat(".txt")
        );

        try {
            Scanner scanner = new Scanner(file);

            switch(scanner.nextLine()){
                case "Titan":
                    this.hero = Titan.builder()
                            .name(scanner.nextLine())
                            .level(Integer.parseInt(scanner.nextLine()))
                            .exp(Integer.parseInt(scanner.nextLine()))
                            .atk(Integer.parseInt(scanner.nextLine()))
                            .def(Integer.parseInt(scanner.nextLine()))
                            .hp(Integer.parseInt(scanner.nextLine()))
                            .build();
                    hero.setHpLevel(hero.getHp());
                    break;
                case "Warlock":
                    this.hero = Warlock.builder()
                            .name(scanner.nextLine())
                            .level(Integer.parseInt(scanner.nextLine()))
                            .exp(Integer.parseInt(scanner.nextLine()))
                            .atk(Integer.parseInt(scanner.nextLine()))
                            .def(Integer.parseInt(scanner.nextLine()))
                            .hp(Integer.parseInt(scanner.nextLine()))
                            .build();
                    hero.setHpLevel(hero.getHp());
                    break;
                case "Hunter":
                    this.hero = Hunter.builder()
                            .name(scanner.nextLine())
                            .level(Integer.parseInt(scanner.nextLine()))
                            .exp(Integer.parseInt(scanner.nextLine()))
                            .atk(Integer.parseInt(scanner.nextLine()))
                            .def(Integer.parseInt(scanner.nextLine()))
                            .hp(Integer.parseInt(scanner.nextLine()))
                            .build();
                    hero.setHpLevel(hero.getHp());
                    break;
            }

            String itemName = scanner.nextLine();

            switch (itemName){
                case "DubstepGun":
                    hero.setItem(DubstepGun.builder().build());
                    break;
                case "Izanagis":
                    hero.setItem(Izanagis.builder().build());
                    break;
                case "LeviathansBreath":
                    hero.setItem(LeviathansBreath.builder().build());
                    break;
                case "LuckyPants":
                    hero.setItem(LuckyPants.builder().build());
                    break;
                case "OneEyedMask":
                    hero.setItem(OneEyedMask.builder().build());
                    break;
                case "TheStag":
                    hero.setItem(TheStag.builder().build());
                    break;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
