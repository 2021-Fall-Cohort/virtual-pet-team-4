package virtual_pet;

public abstract class RoboticPet extends VirtualPet{
    protected int oilLevel;
    protected int maintenanceLevel;

    public RoboticPet(String name, String sex, String breed, String pronoun, int age, int id) {
        super(name, sex, breed, pronoun, age, id);
        this.oilLevel = 0;
        this.maintenanceLevel = 0;
    }

    abstract public void giveOil();

    abstract public void doMaintenance();
}
