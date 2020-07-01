package za.co.WeThinkCode_.swingy.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;
import za.co.WeThinkCode_.swingy.model.legendary.OneEyedMask;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class Titan extends Hero{
    @Builder.Default
    @ToString.Exclude
    protected int atk = 15;
    @Builder.Default
    @ToString.Exclude
    protected int def = 35;
    @Builder.Default
    @ToString.Exclude
    protected Legendary item = OneEyedMask.builder().build();

    void levelUp(){
        this.exp = 0;
        this.atk *= 1.1;
        this.def *= 1.2;
        this.level += 1;
    }
}
