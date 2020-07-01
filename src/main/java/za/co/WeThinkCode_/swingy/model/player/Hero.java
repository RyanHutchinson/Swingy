package za.co.WeThinkCode_.swingy.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.model.enemy.Enemy;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;

@SuperBuilder
@Getter
@ToString
public class Hero {
    @NonNull
    protected String name;
    @Builder.Default
    protected int level = 1;
    @Builder.Default
    protected int exp = 0;
    @Builder.Default
    protected int atk = 0;
    @Builder.Default
    protected int def = 0;
    @Builder.Default
    protected int hp = 100;
    @Builder.Default
    protected int[] coordinates = {0,0};
    protected Legendary item;

    public boolean endRound(){

        this.coordinates[0] = 0;
        this.coordinates[1] = 0;
        this.hp = 100;
        this.exp += (level * 100);
        if(this.exp >= (this.level * 1000 + ((level - 1) * (level - 1)) * 450)){
            levelUp();
            return true;
        }else{
            return false;
        }
    }

    public String move(String direction){

        int bounds = (((level-1) * 5 + 10 - (level%2)) - 1) / 2;

        switch (direction){
            case "n":
                this.coordinates[0] += 1;
                break;
            case "s" :
                this.coordinates[0] -= 1;
                break;
            case "e" :
                this.coordinates[1] += 1;
                break;
            case "w" :
                this.coordinates[1] -= 1;
                break;
        }
        if((this.coordinates[0] >= bounds) || (this.coordinates[0] <= (bounds * -1)) ||
                (this.coordinates[1] <= (bounds * -1)) || (this.coordinates[1] >= bounds)){
            if(this.endRound())
                return "END&DING";
            else
                return "END";
        } else {
            return "CONTINUE";
        }
    }

    public boolean fight(Enemy enemy){

        int playerHP = this.getHp() + this.getDef() + this.getItem().getDef();
        int playerATK = this.getAtk() + this.getItem().getAtk();

        float enemyHP = enemy.getHp() * (1 + ((float)this.getLevel()/10));
        float enemyATK = enemy.getAtk() * (1 + ((float)this.getLevel()/10));

        while(enemyHP >= 0 && playerHP >= 0){
            enemyHP -= playerATK;
            playerHP -= enemyATK;
        }

        return playerHP > 0;
    }

    void levelUp(){ } //method exists in Children
}
