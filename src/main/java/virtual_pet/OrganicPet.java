package virtual_pet;

public abstract class OrganicPet extends VirtualPet {
    protected int bathroomNeeds;
    protected int hungerLevel;
    protected boolean isHungry;

    public OrganicPet(String name, String sex, String breed, String pronoun, int age, int id, int favoriteFood, int favoriteToy) {
        super(name, sex, breed, pronoun, age, id, favoriteFood, favoriteToy);
        this.bathroomNeeds = 0;
        this.hungerLevel = 20;
    }

    abstract public void feed();

    abstract public void addHunger();
}
