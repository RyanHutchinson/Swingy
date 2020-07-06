package za.co.WeThinkCode_.swingy.model.player;

import lombok.*;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.enemy.*;
import za.co.WeThinkCode_.swingy.model.legendary.Legendary;

import java.util.Random;

@SuperBuilder
@Getter
@Setter
@ToString
public abstract class Hero {
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

    public LogicController.Stage move(String direction){

        int bounds = (((level-1) * 5 + 10 - (level%2)) - 1) / 2;

        switch (direction){
            case "1":
                this.coordinates[0] += 1;
                break;
            case "2" :
                this.coordinates[0] -= 1;
                break;
            case "3" :
                this.coordinates[1] += 1;
                break;
            case "4" :
                this.coordinates[1] -= 1;
                break;
        }
        if((this.coordinates[0] >= bounds) || (this.coordinates[0] <= (bounds * -1)) || (this.coordinates[1] <= (bounds * -1)) || (this.coordinates[1] >= bounds))
            return (this.endRound())? LogicController.Stage.END_ROUND_DING : LogicController.Stage.END_ROUND;
        else
            return (this.doesFight())? LogicController.Stage.FIGHT : LogicController.Stage.PLAY_MOVE;
    }
    public LogicController.Stage fight(){
        Enemy enemy = randomEnemy();
        int playerHP = this.getHp() + this.getDef() + this.getItem().getDef();
        int playerATK = this.getAtk() + this.getItem().getAtk();

        float enemyHP = enemy.getHp() * (1 + ((float)this.getLevel()/10));
        float enemyATK = enemy.getAtk() * (1 + ((float)this.getLevel()/10));

        while(enemyHP >= 0 && playerHP >= 0){
            enemyHP -= playerATK;
            playerHP -= enemyATK;
        }
        this.exp += (this.getLevel()) * 100;
        return (playerHP > 0)? LogicController.Stage.FIGHT_WON : LogicController.Stage.FIGHT_LOST;

    }

    private boolean doesFight(){
        Random rand = new Random();
        int chance = rand.nextInt(1000);

        return (chance > 300);
    }
    private Enemy randomEnemy(){
        int type = new Random().nextInt(4);
        Enemy enemy;

        switch (type){
            case 0:
                enemy = Cabal.builder().build();
                break;
            case 1:
                enemy = Fallen.builder().build();
                break;
            case 2:
                enemy = Hive.builder().build();
                break;
            case 3:
                enemy = Vex.builder().build();
                break;
            default:
                enemy = Cabal.builder().build();
                break;
        }
        return enemy;
    }
    private boolean endRound(){

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
    void levelUp(){ } //method exists in Children
}
