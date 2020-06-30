package za.co.WeThinkCode_.swingy;

import za.co.WeThinkCode_.swingy.model.player.Customer;

import javax.validation.constraints.Null;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String thing = null;


        boolean state = true;
        while (state){
            System.out.print("Gimme nem: ");
            if((thing = scn.nextLine()).equals("")){
                thing = null;
            }
            try{
                Customer test = Customer.builder().id(1).name(thing).build();
                System.out.println(test);
                state = false;
            }catch (NullPointerException e){
                System.out.println("Name cannot be empty");
            }
        }


    }
}
