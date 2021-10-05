package virtual_pet;

public abstract class VirtualPet {
    protected String name;
    protected String sex;
    protected String breed;
    protected String pronoun;
    protected int favoriteFood;
    protected int favoriteToy;
    protected int healthLevel;
    protected int thirstLevel;
    protected int boredomLevel;
    protected int age;
    protected int id;
    protected boolean isBored;
    protected boolean isThirsty;

    public VirtualPet(String name, String sex, String breed, String pronoun, int age, int id, int favoriteToy ) {
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.pronoun = pronoun;
        this.age = age;
        this.id = id;
        this.favoriteToy = favoriteToy;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBreed() {
        return breed;
    }

    public String getPronoun() {
        return pronoun;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getFavoriteToy() {return favoriteToy; }

    public boolean isBored() {
        return isBored;
    }

    public boolean isThirsty() {
        return isThirsty;
    }

    abstract public void water();

    abstract public void play();

    abstract public void tick();

    abstract public void statusCheck();

    abstract public String status();

    abstract public String info();

    abstract public String interactionList();

    abstract public void addThirst();

    abstract public void addBoredom();

    abstract public void walk();
}
