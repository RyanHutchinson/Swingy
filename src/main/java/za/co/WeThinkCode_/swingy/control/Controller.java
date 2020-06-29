package za.co.WeThinkCode_.swingy.control;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Controller {

    private String view;

    public Controller(String inputView){
        this.view = inputView;
    }

    public void whatIsView(){
        System.out.println(view);
    }
}
