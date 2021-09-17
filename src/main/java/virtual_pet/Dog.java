package virtual_pet;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Dog {
    private String name;
    private String sex;                         //added sex needs display in status
    private String breed;                       //added breed needs display in status
    private int healthLevel;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private boolean dogIsBored;
    private boolean dogIsHungry;
    private boolean dogIsThirsty;
    private boolean dogIsDying;
    private boolean dogIsAlive;
    private String outputMessage;

    Scanner scanner = new Scanner(System.in);
    public Dog(String name, String sex, String breed) {
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.healthLevel = 100;
        this.hungerLevel = 20;
        this.thirstLevel = 20;
        this.boredomLevel = 20;
        this.dogIsBored = false;
        this.dogIsHungry = false;
        this.dogIsThirsty = false;
        this.dogIsDying = false;
        this.dogIsAlive = true;
    }

    public Dog(String name, String sex, String breed, int healthLevel, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.healthLevel = healthLevel;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.dogIsBored = false;
        this.dogIsHungry = false;
        this.dogIsThirsty = false;
        this.dogIsDying = false;
        this.dogIsAlive = true;
    }
    public int getHealthLevel() {
        return healthLevel;
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
    public void getOutputMessage() {
        System.out.println(outputMessage);
    }

    public boolean getDogIsAlive() {
        return dogIsAlive;
    }

    public void feedDog() {
        clearScreen();
        System.out.println("What would you like to feed " + name + "?");
        System.out.println("1. Kibble");
        System.out.println("2. Treat");
        System.out.println("3. Peanut Butter");
        int foodChoice = scanner.nextInt();
        switch (foodChoice) {
            case 1:
                dogEatingKibble();
                hungerLevel = hungerLevel - 20;
                thirstLevel = thirstLevel + 5;
                boredomLevel = boredomLevel - 5;
                outputMessage = (name + " ate their dinner and lost 20 hunger" + "\n");
                break;
            case 2:
                dogEatingTreat();
                hungerLevel = hungerLevel - 5;
                thirstLevel = thirstLevel + 1;
                boredomLevel = boredomLevel - 1;
                outputMessage= (name + " ate their treat and lost 5 hunger" + "\n");
                break;
            case 3:
                dogEatingPeanutButter();
                hungerLevel = hungerLevel - 5;
                thirstLevel = thirstLevel + 5;
                boredomLevel = boredomLevel - 5;
                outputMessage = (name + " loved their peanut butter and lost 5 hunger" + "\n");
                break;
        }
    }

    public void waterDog() {
        thirstLevel = thirstLevel - 20;
        hungerLevel++;
    }

    public void playWithDog() {
        clearScreen();
        System.out.println("What game would you like to play with " + name + "?");
        System.out.println("1. Fetch");
        System.out.println("2. Tug-of-War");
        System.out.println("3. Frisbee");
        int playChoice = scanner.nextInt();
        switch (playChoice) {
            case 1:
                dogPlayingFetch();
                outputMessage = (name + " really enjoyed playing fetch with you!" + "\n");
                break;
            case 2:
                dogPlayingTugofWar();
                outputMessage = (name + " had a great time playing Tug-of-War!" + "\n");
                break;
            case 3:
                dogPlayingFrisbee();
                outputMessage = (name + " really seemed to like playing with the frisbee" + "\n");
                break;
        }
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
        statusCheck();
        if (dogIsBored || dogIsThirsty || dogIsHungry) {
            healthLevel = healthLevel - 5;
        } else if (healthLevel < 100 ) {
            healthLevel = healthLevel + 5;
        }
        if (healthLevel <= 0) {
            dogIsAlive = false;
        }
    }

    public void dogNeutral() {
        System.out.println(" \\ ______/ V`-,\n" +
                "  }        /~~\n" +
                " /_)^ --,r'\n" +
                "|b      |b");
    }

    public void dogPlayingFetch() {
        clearScreen();
        System.out.println("Let's play Fetch with " + name + "!");
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

    public void dogPlayingTugofWar() {
        clearScreen();
        System.out.println("Let's play Tug-of-War with " + name + "!");
        System.out.println("    ___\n" +
                " __/_  `.  .-\"\"\"-.\n" +
                " \\_,` | \\-'  /   )`-')\n" +
                "  \"\") `\"`    \\  ((`\"`\n" +
                " ___Y  ,    .'7 /|\n" +
                "(_,___/...-` (_/_/");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogPlayingFrisbee() {
        clearScreen();
        System.out.println("Let's play Frisbee with " + name + "!");
        System.out.println("          \"\",_o\n" +
                "!       ( (  _)\n" +
                "`\\ ,,,,_'),)=~\n" +
                " (          )\n" +
                "  ,   ,,,,  ,\n" +
                "  ) ,)   < (\n" +
                " < <      \",\\\n" +
                "  \",)      \"_)");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogEatingKibble() {
        clearScreen();
        System.out.println("Let's feed " + name + "!");
        System.out.println("\n" +
                "    `. ---)..(\n" +
                "      ||||(,o)          \n" +
                "      \"`'\" \\__/");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogEatingTreat() {
        clearScreen();
        System.out.println("Let's give " + name + " a treat!");
        System.out.println(" ________________\n" +
                "    '------._.------'\\\n" +
                "      \\_______________\\\n" +
                "     .'|            .'|\n" +
                "   .'_____________.' .|\n" +
                "   |              |   |\n" +
                "   |  Scooby _.-. | . |\n" +
                "   |  *     (_.-' |   |\n" +
                "   |    Snacks    |  .|\n" +
                "   | *          * |  .'\n" +
                "   |______________|.'");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void dogEatingPeanutButter() {
        clearScreen();
        System.out.println("Let's give " + name + " some peanut butter!");
        System.out.println("                        _.--\"\"\"--._\n" +
                "                      .'       '-. `.\n" +
                "                   __/__    (-.   `\\ \\\n" +
                "                  /o `o \\      \\    \\ \\\n" +
                "                 _\\__.__/ ))    |    | ;\n" +
                "            .--;\"               |    |  \\\n" +
                "           (    `)              |    |   \\\n" +
                "          _|`---' .'      _,   _|    |    `\\\n" +
                "        '`_\\  \\     '_,.-';_.-`\\|     \\     \\_\n" +
                "        .'  '--'---;`  / /     |\\     |_..--' \\\n" +
                "                   \\'-'.'     .--'.__/    __.-;\n" +
                "                    `\"`      (___...---''`     \\\n" +
                "                             _/_                \\\n" +
                "                            /\\\n" +
                "                            \\___/");
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
        System.out.println("Let's give " + name + " some water" + "!");
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
        if (healthLevel <= 25) {
            dogIsDying = true;
        } else {
            dogIsDying = false;
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

    public void status() {
        // LocalTime clock = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
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

        if (dogIsDying) {
            System.out.println("WARNING: " + name + " is dying! Take care of their needs!!");
        }

        System.out.println(name + "'s current stats are: \n" +
                "Health: " + healthLevel + "\n" +
                "Hunger Level: " + hungerLevel + "\n" +
                "Thirst Level: " + thirstLevel + "\n" +
                "Boredom Level: " + boredomLevel + "\n");

    }

    public void info() {
        clearScreen();
        System.out.println(name + "'s information: \n" +
                "Name: " + name + "\n" +
                "Breed: " + breed + "\n" +
                "Gender: " + sex + "\n");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
