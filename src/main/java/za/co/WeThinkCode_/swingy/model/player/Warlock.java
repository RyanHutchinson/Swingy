package za.co.WeThinkCode_.swingy.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;
import za.co.WeThinkCode_.swingy.model.legendary.TheStag;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class Warlock extends Hero{
    @Builder.Default
    @ToString.Exclude
    protected int atk = 35;
    @Builder.Default
    @ToString.Exclude
    protected int def = 15;
    @Builder.Default
    @ToString.Exclude
    protected Legendary item = TheStag.builder().build();

    void levelUp(){
        this.exp = 0;
        this.atk *= 1.2;
        this.def *= 1.1;
        this.level += 1;
    }

}
