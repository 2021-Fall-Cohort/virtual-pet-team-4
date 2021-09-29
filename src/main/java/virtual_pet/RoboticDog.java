package virtual_pet;

import java.util.Random;

public class RoboticDog extends RoboticPet{

    public RoboticDog(String name, String sex, String breed, String pronoun, int age, int id, int oilLevel, int maintenanceLevel) {
        super(name, sex, breed, pronoun, age, id, oilLevel, maintenanceLevel);
    }

    @Override
    public void giveOil() {
        oilLevel -= 20;
    }

    @Override
    public void doMaintenance() {
        maintenanceLevel -= 20;
    }

    @Override
    public void water() {
        thirstLevel -= 20;
    }

    @Override
    public void play() {
        boredomLevel -= 20;
    }

    @Override
    public void tick() {
        int min = 1;
        int max = 3;
        Random random = new Random();
        int randomThirst = random.nextInt(max + min) + min;
        int randomBoredom = random.nextInt(max + min) + min;
        thirstLevel = thirstLevel + randomThirst;
        boredomLevel = boredomLevel + randomBoredom;
        statusCheck();
        if (isBored || isThirsty) {
            healthLevel = healthLevel - 5;
        } else if (healthLevel < 100 ) {
            healthLevel = healthLevel + 5;
        }
    }

    @Override
    public void statusCheck() {
        if (thirstLevel >= 75){
            isThirsty = true;
        }else {
            isThirsty = false;
        }
        if (boredomLevel >= 75) {
            isBored = true;
        }else {
            isBored = false;
        }
        if (thirstLevel < 0) {
            thirstLevel = 0;
        }
        if (boredomLevel < 0) {
            boredomLevel = 0;
        }
        if (thirstLevel > 100) {
            thirstLevel = 100;
        }
        if (boredomLevel > 100) {
            boredomLevel = 100;
        }
    }

    @Override
    public String status() {
        statusCheck();
        return(name + " | " + thirstLevel + "     | " + boredomLevel);
    }

    @Override
    public String info() {
        return(name + " | " + age + "   |  " + sex + "     | " + breed);
    }

    @Override
    public String interactionList() {
        return(" " + id + "    |  " + name + " |    " + age + "   |   " + breed);
    }

    @Override
    public void addThirst() {
        thirstLevel++;
    }

    @Override
    public void addBoredom() {
        boredomLevel++;
    }
}