package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class OrganicCat extends OrganicPet{
    private int litterBoxCleanliness;

    public OrganicCat(String name, String sex, String breed, String pronoun, int age, int id, int favoriteToy) {
        super(name, sex, breed, pronoun, age, id, favoriteToy);
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.pronoun = pronoun;
        this.age = age;
        this.id = id;
        litterBoxCleanliness = 0;
    }

    @Override
    public void feed() {

        hungerLevel -= 20;

    }

    @Override
    public void addHunger() {
        hungerLevel++;
    }

    public int getLitterBoxCleanliness() {
        return litterBoxCleanliness;
    }

    @Override
    public int getHunger() {
        return hungerLevel;
    }

    @Override
    public int getBathroomNeeds() {
        return bathroomNeeds;
    }

    @Override
    public void water() {
        thirstLevel -= 20;
    }

    @Override
    public void play() {
        boredomLevel -= 20;
        System.out.println("Toy options: \n" +
                "1. Chew toy \n" +
                "2. Ball \n" +
                "3. String \n");
        Scanner favScanner = new Scanner(System.in);
        int toySelection = favScanner.nextInt();
        if (toySelection == 1)
            toySelection = 0;
        if (toySelection == 2)
            toySelection = 1;
        if (toySelection == 3)
            toySelection = 2;
        if (toySelection == favoriteToy) {
            boredomLevel -= 10;
        }
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
        bathroomNeeds++;
        if (bathroomNeeds < 5) {
            litterBoxCleanliness++;
        } else if (bathroomNeeds < 10) {
            litterBoxCleanliness += 2;
        } else if (bathroomNeeds < 20) {
            litterBoxCleanliness += 3;
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
    public void addThirst() {
        thirstLevel++;
    }

    @Override
    public void addBoredom() {
        boredomLevel++;
    }

    @Override
    public void walk() {
        bathroomNeeds = 0;
        boredomLevel -= 20;
    }

    public void cleanLitterBox() {
        litterBoxCleanliness = 0;
    }
}
