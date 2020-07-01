//package za.co.WeThinkCode_.swingy;
//
//import za.co.WeThinkCode_.swingy.gameutils.ConsoleColors;
//import za.co.WeThinkCode_.swingy.model.player.Hero;
//import za.co.WeThinkCode_.swingy.model.player.Hunter;
//import za.co.WeThinkCode_.swingy.model.player.Titan;
//import za.co.WeThinkCode_.swingy.model.player.Warlock;
//import java.util.Scanner;
//
//public class main {
//    public static void main(String[] args) {
//
//        Scanner scn = new Scanner(System.in);
//        int[] inputs = {0,0,0};
//        String name = null;
//
//        while(inputs[0] < 1 || inputs[0] > 3){
//            System.out.print(   ConsoleColors.BLACK_BOLD +
//                    ConsoleColors.PURPLE_BACKGROUND +  " 1)Warlock " +
//                    ConsoleColors.CYAN_BACKGROUND + " 2)Titan  " +
//                    ConsoleColors.YELLOW_BACKGROUND + " 3)Hunter " +
//                    ConsoleColors.RESET + "\nGimme class:  ");
//            inputs[0] = Integer.parseInt(scn.nextLine());
//        }
//
//        System.out.print("Gimme level:  ");
//        inputs[1] = Integer.parseInt(scn.nextLine());
//        System.out.print("Gimme exp:  ");
//        inputs[2] = Integer.parseInt(scn.nextLine());
//
//        boolean state = true;
//        while (name == null){
//            System.out.print("Gimme nem:  ");
//            if((name = scn.nextLine()).equals("")){
//                name = null;
//            }
//            try{
//                Hero test;
//                if(inputs[0] == 1){
//                    test = Warlock.builder()
//                            .name(name)
//                            .level(inputs[1])
//                            .exp(inputs[2])
//                            .build();
//                } else if(inputs[0] == 2){
//                    test = Titan.builder()
//                            .name(name)
//                            .level(inputs[1])
//                            .exp(inputs[2])
//                            .build();
//                } else{
//                    test = Hunter.builder()
//                            .name(name)
//                            .level(inputs[1])
//                            .exp(inputs[2])
//                            .build();
//                }
//                System.out.println(test.toString());
//                if(test.endRound()){
//                    System.out.println( "\n****************************************" +
//                            "\nyou have leveled up!\n" +
//                            "*****************************************\n");
//                }
//                System.out.println(test.toString());
//                state = false;
//            }catch (NullPointerException e){
//                System.out.println("Name cannot be empty");
//            }
//        }
//    }
//}
//**************************************************************************************
//**************************MOVEMENT TESTER************************************************************
//**************************************************************************************


//        Scanner scanner = new Scanner(System.in);
//                Hero player = Warlock.builder()
//                .name("Ryan")
//                .level(1)
//                .exp(950)
//                .build();
//                String state = "CONTINUE";
//                while(state.equals("CONTINUE")){
//                System.out.println("Which direction:  ");
//                state = player.move(scanner.nextLine());
//                if(state.equals("END")){
//                System.out.print("You reached the end of the level!\n");
//                } else if (state.equals("END&DING")){
//                System.out.printf("Congradulations %s! You have reached the end of the level and leveled up to level %d!!!\n",player.getName(),player.getLevel());
//                }
//                }
//                System.out.println(player);
//                }
