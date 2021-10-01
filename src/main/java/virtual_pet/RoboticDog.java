package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class RoboticDog extends RoboticPet{

    public RoboticDog(String name, String sex, String breed, String pronoun, int age, int id, int favoriteFood, int favoriteToy) {
        super(name, sex, breed, pronoun, age, id, favoriteFood, favoriteToy);
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.pronoun = pronoun;
        this.age = age;
        this.id = id;
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
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
    public int getOilLevel() {
        return oilLevel;
    }

    @Override
    public int getMaintenanceLevel() {
        return maintenanceLevel;
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

    @Override
    public void walk() {
        oilLevel -= 20;
        maintenanceLevel -= 20;
    }
}
