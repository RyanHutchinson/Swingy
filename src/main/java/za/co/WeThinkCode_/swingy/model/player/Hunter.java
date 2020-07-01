package za.co.WeThinkCode_.swingy.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;
import za.co.WeThinkCode_.swingy.model.legendary.LuckyPants;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class Hunter extends Hero{
    @Builder.Default
    @ToString.Exclude
    protected int atk = 25;
    @Builder.Default
    @ToString.Exclude
    protected int def = 25;
    @Builder.Default
    @ToString.Exclude
    protected Legendary item = LuckyPants.builder().build();

    void levelUp(){
        this.exp = 0;
        this.atk *= 1.15;
        this.def *= 1.15;
        this.level += 1;
    }
}
