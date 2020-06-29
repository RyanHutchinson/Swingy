package za.co.WeThinkCode_.swingy;

public class main{
    public static void main(String[] args) {

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("-console")) {
                System.out.println("go to console control");
            } else if (args[0].equalsIgnoreCase("-gui")) {
                System.out.println("go to gui control");
            } else {
                System.out.println("Invalid command.\nPlease use a valid flag: [-gui , -console]");
            }
        } else {
            System.out.println("Invalid command.\nPlease use a valid flag: [-gui , -console]");
        }
    }
}
