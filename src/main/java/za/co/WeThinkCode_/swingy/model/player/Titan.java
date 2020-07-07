package za.co.WeThinkCode_.swingy.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;
import za.co.WeThinkCode_.swingy.model.legendary.OneEyedMask;

@SuperBuilder
@Setter
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
        this.atk = (int)Math.ceil(this.atk * 1.05);
        this.def = (int)Math.ceil(this.def * 1.1);
        this.hp = (int)Math.ceil(this.hp * 1.1);
        this.level += 1;
    }
}
