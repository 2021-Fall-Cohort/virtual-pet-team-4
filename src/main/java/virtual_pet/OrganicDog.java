package virtual_pet;

import java.util.Random;

public class OrganicDog extends OrganicPet{

    public OrganicDog(String name, String sex, String breed, String pronoun, int age, int id, int bathroomNeeds, int hungerLevel, boolean isHungry) {
        super(name, sex, breed, pronoun, age, id, bathroomNeeds, hungerLevel, isHungry);
    }

    @Override
    public void feed() {
        hungerLevel -= 20;
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
        int randomHunger = random.nextInt(max + min) + min;
        int randomThirst = random.nextInt(max + min) + min;
        int randomBoredom = random.nextInt(max + min) + min;
        hungerLevel = hungerLevel + randomHunger;
        thirstLevel = thirstLevel + randomThirst;
        boredomLevel = boredomLevel + randomBoredom;
        statusCheck();
        if (isBored || isThirsty || isHungry) {
            healthLevel = healthLevel - 5;
        } else if (healthLevel < 100 ) {
            healthLevel = healthLevel + 5;
        }
    }

    @Override
    public void statusCheck() {
        if (hungerLevel >= 75) {
            isHungry = true;
        }else {
            isHungry = false;
        }
        if (thirstLevel >= 75) {
            isThirsty = true;
        }else {
            isThirsty = false;
        }
        if (boredomLevel >= 75) {
            isBored = true;
        }else {
            isBored = false;
        }
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        if (thirstLevel < 0) {
            thirstLevel = 0;
        }
        if (boredomLevel < 0) {
            boredomLevel = 0;
        }
        if (hungerLevel > 100 ) {
            hungerLevel = 100;
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
        return(name + " | " + hungerLevel + "     | " + thirstLevel + "     | " + boredomLevel);
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
    public void addHunger() {
        hungerLevel++;
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
