package virtual_pet;

import java.sql.Time;
import java.util.Random;

public class Dog {
    private String name;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private boolean dogIsBored;
    private boolean dogIsHungry;
    private boolean dogIsThirsty;

    // Clock clock = Clock();

    public Dog(String name) {
        this.name = name;
        this.hungerLevel = 50;
        this.thirstLevel = 50;
        this.boredomLevel = 50;
        this.dogIsBored = false;
        this.dogIsHungry = false;
        this.dogIsThirsty = false;
    }

    public Dog(String name, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.dogIsBored = false;
        this.dogIsHungry = false;
        this.dogIsThirsty = false;
    }

    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public void feedDog() {
        hungerLevel = hungerLevel - 20;
        thirstLevel = thirstLevel + 5;
        boredomLevel = boredomLevel - 5;
    }

    public void waterDog() {
        thirstLevel = thirstLevel - 20;
        hungerLevel++;
    }

    public void playWithDog() {
        boredomLevel = boredomLevel - 20;
        thirstLevel = thirstLevel + 10;
        hungerLevel = hungerLevel + 10;
    }

    public void addHunger() {
        hungerLevel = hungerLevel++;
    }

    public void addThirst() {
        thirstLevel = thirstLevel++;
    }

    public void addBoredom() {
        boredomLevel = boredomLevel++;
    }

    public void tick() {
        int min = 1;
        int max = 5;
        Random random = new Random();
        int randomHunger = random.nextInt(max + min) + min;
        int randomThirst = random.nextInt(max + min) + min;
        int randomBoredom = random.nextInt(max + min) + min;
        hungerLevel = hungerLevel + randomHunger;
        thirstLevel = thirstLevel + randomThirst;
        boredomLevel = boredomLevel + randomBoredom;

//        if (hungerLevel >= 75) {                             //block moved to the status method//
//             Boolean dogIsHungry = true;
//        }
//        if (thirstLevel >= 75) {
//            Boolean dogIsThirsty = true;
//        }
//        if (boredomLevel >= 75) {
//            Boolean dogIsBored = true;
//        }
    }

    public void dogNeutral() {
        System.out.println(" \\ ______/ V`-,\n" +
                "  }        /~~\n" +
                " /_)^ --,r'\n" +
                "|b      |b");
    }

    public void dogPlaying() {
        clearScreen();
        System.out.println("Let's play with " + name + "!");
        System.out.println("             .--~~,__\n" +
                ":-....,-------`~~'._.'\n" +
                " `-,,,  ,_      ;'~U'\n" +
                "  _,-' ,'`-__; '--.\n" +
                " (_/'~~      ''''(;");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogEating() {
        clearScreen();
        System.out.println("Let's feed " + name);
        System.out.println("    ,    /-.\n" +
                "   ((___/ __>\n" +
                "   /      }\n" +
                "   \\ .--.(    ___\n" +
                " \\\\   \\\\  /___\\");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogDrinking() {
        clearScreen();
        System.out.println("Let's give " + name + " some water");
        System.out.println("    ,    /-.\n" +
                "   ((___/ __>\n" +
                "   /      }\n" +
                "   \\ .--.(    ___\n" +
                " \\\\   \\\\  /___\\");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
    }

    public void statusCheck() {
        if (hungerLevel >= 75) {
            dogIsHungry = true;
        }else {
            dogIsHungry = false;
        }
        if (thirstLevel >= 75) {
            dogIsThirsty = true;
        }else {
            dogIsThirsty = false;
        }
        if (boredomLevel >= 75) {
            dogIsBored = true;
        }else {
            dogIsBored = false;
        }
    }

    public void status() {
        statusCheck();
        clearScreen();

        if (dogIsBored) {
            System.out.println("WARNING: " + name + " is getting really bored! Maybe you guys should play.");
        }

        if (dogIsThirsty) {
            System.out.println("WARNING: " + name + " is getting thirty. Better get them some water!");
        }

        if (dogIsHungry) {
            System.out.println("WARNING: " + name + " is withering away. Time for another meal!");
        }

        System.out.println(name + "'s current stats are: " + "\n" +
                "Hunger Level: " + hungerLevel + "\n" +
                "Thirst Level: " + thirstLevel + "\n" +
                "Boredom Level: " + boredomLevel);

    }
}
