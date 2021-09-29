package virtual_pet;

public abstract class OrganicPet extends VirtualPet {
    protected int bathroomNeeds;
    protected int hungerLevel;
    protected boolean isHungry;

    public OrganicPet(String name, String sex, String breed, String pronoun, int age, int id, int bathroomNeeds, int hungerLevel, boolean isHungry) {
        super(name, sex, breed, pronoun, age, id);
        this.bathroomNeeds = bathroomNeeds;
        this.hungerLevel = hungerLevel;
        this.isHungry = isHungry;
    }

    abstract public void feed();

    abstract public void addHunger();
}
