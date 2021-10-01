package virtual_pet;

public abstract class RoboticPet extends VirtualPet{
    protected int oilLevel;
    protected int maintenanceLevel;

    public RoboticPet(String name, String sex, String breed, String pronoun, int age, int id,  int favoriteFood, int favoriteToy) {
        super(name, sex, breed, pronoun, age, id, favoriteFood, favoriteToy);
        this.oilLevel = 0;
        this.maintenanceLevel = 0;
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    abstract public void giveOil();

    abstract public void doMaintenance();

    abstract public int getOilLevel();

    abstract public int getMaintenanceLevel();
}
