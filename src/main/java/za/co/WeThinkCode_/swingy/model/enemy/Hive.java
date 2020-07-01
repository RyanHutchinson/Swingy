package za.co.WeThinkCode_.swingy.model.enemy;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class Hive extends Enemy{
    @Builder.Default
    @ToString.Exclude
    protected int atk = 25;
    @Builder.Default
    @ToString.Exclude
    protected int def = -10;
}