package za.co.WeThinkCode_.swingy.model.player;

import lombok.*;
import lombok.experimental.SuperBuilder;
import za.co.WeThinkCode_.swingy.control.LogicController;
import za.co.WeThinkCode_.swingy.model.enemy.*;
import za.co.WeThinkCode_.swingy.model.legendary.*;

import java.util.Random;

@Getter
@Setter
@ToString
@SuperBuilder
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
    protected int hpLevel = 100;
    @Builder.Default
    protected int hp = 100;
    @Builder.Default
    protected int[] coordinates = {0,0};
    protected Legendary item;

    public LogicController.Stage move(String direction){

        int bounds = (((level-1) * 5 + 10 - (level%2)) - 1) / 2;
        this.hp = ((this.coordinates[0] == 0) && (this.coordinates[1] == 0))? this.hpLevel: this.hp;

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
        this.hp = playerHP;
        if(playerHP > 0){
            return (doesDropItem())? LogicController.Stage.FIGHT_WON_DROPPED_ITEM : LogicController.Stage.FIGHT_WON;
        } else {
            return LogicController.Stage.FIGHT_LOST;
        }
    }

    private boolean doesDropItem(){
        Random rand = new Random();
        int chance = rand.nextInt(1000);

        return (chance > 1); //TODO change value post testing
    }

    private boolean doesFight(){
        Random rand = new Random();
        int chance = rand.nextInt(1000);

        return (chance > 300); //TODO change value post testing
    }

    private Enemy randomEnemy(){
        int type = new Random().nextInt(4);
        Enemy enemy = null;

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
        }
        return enemy;
    }

    public Legendary randomItem(){
        int type = new Random().nextInt(6);
        Legendary tempItem = null;

        switch (type){
            case 0:
                tempItem = DubstepGun.builder().build();
                break;
            case 1:
                tempItem = Izanagis.builder().build();
                break;
            case 2:
                tempItem = LeviathansBreath.builder().build();
                break;
            case 3:
                tempItem = LuckyPants.builder().build();
                break;
            case 4:
                tempItem = OneEyedMask.builder().build();
                break;
            case 5:
                tempItem = TheStag.builder().build();
                break;
        }
        return tempItem;
    }

    public boolean endRound(){

        this.coordinates[0] = 0;
        this.coordinates[1] = 0;

        if (this.getHp() <= 0){
            this.setHp(this.hpLevel);
            return false;
        } else {
            this.setHp(this.hpLevel);
            this.exp += (level * 100);
            if(this.exp >= (this.level * 1000 + ((level - 1) * (level - 1)) * 450)) {
                levelUp();
                return true;
            }else{
                return false;
            }
        }
    }

    void levelUp(){ } //method exists in Children
}
