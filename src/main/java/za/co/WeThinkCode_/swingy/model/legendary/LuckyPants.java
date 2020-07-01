package za.co.WeThinkCode_.swingy.model.legendary;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class LuckyPants extends Legendary{

    @Builder.Default
    protected int atk = 40;
    @Builder.Default
    protected int def = 10;

}
