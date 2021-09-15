package virtual_pet;

public class Dog {
    private String name;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;

    public Dog(String name) {
        this.name = name;
        this.hungerLevel = 50;
        this.thirstLevel = 50;
        this.boredomLevel = 50;
    }

    public Dog(String name, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
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
    }

    public void waterDog() {
        thirstLevel = thirstLevel - 20;
    }

    public void playWithDog() {
        boredomLevel = boredomLevel - 20;
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
        hungerLevel++;
        thirstLevel++;
        boredomLevel++;

        if (hungerLevel >= 75) {
            Boolean dogIsHungry = true;
        }
        if (thirstLevel >= 75) {
            Boolean dogIsThirsty = true;
        }
        if (boredomLevel >= 75) {
            Boolean dogIsBored = true;
        }
    }

    public void status() {
        System.out.println(name + "'s current stats are: " + "\n" +
                "Hunger Level: " + hungerLevel + "\n" +
                "Thirst Level: " + thirstLevel + "\n" +
                "Boredom Level: " + boredomLevel
        );
    }

}
