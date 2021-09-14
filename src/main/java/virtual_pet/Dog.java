package virtual_pet;

public class Dog {
    private String name;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;

    public Dog(String name, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.hungerLevel = 50;
        this.thirstLevel = 50;
        this.boredomLevel = 50;
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
}
