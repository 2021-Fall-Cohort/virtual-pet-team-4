package virtual_pet;

public abstract class RoboticPet extends VirtualPet{
    protected int oilLevel;
    protected int maintenanceLevel;

    public RoboticPet(String name, String sex, String breed, String pronoun, int age, int id, int oilLevel, int maintenanceLevel) {
        super(name, sex, breed, pronoun, age, id);
        this.oilLevel = oilLevel;
        this.maintenanceLevel = maintenanceLevel;
    }

    abstract public void giveOil();

    abstract public void doMaintenance();
}
