package za.co.WeThinkCode_.swingy.model.legendary;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class OneEyedMask extends Legendary{

    @Builder.Default
    protected int atk = 20;
    @Builder.Default
    protected int def = 30;

}
