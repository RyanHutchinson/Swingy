package za.co.WeThinkCode_.swingy.model.legendary;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Legendary {
    protected int atk;
    protected int def;
}
