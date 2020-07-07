package za.co.WeThinkCode_.swingy.model.enemy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString
public class Enemy {
    @Builder.Default
    protected int hp = 100;
    protected int atk;
    protected int def;
}
