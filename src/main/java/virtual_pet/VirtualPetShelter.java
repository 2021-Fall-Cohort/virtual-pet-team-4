package virtual_pet;
import java.util.HashMap;

public class VirtualPetShelter {
    private static HashMap<Integer, Dog> shelterDogs = new HashMap<Integer, Dog>();

    public VirtualPetShelter() {
        shelterDogs = new HashMap<Integer, Dog>();
    }

    public static void addDog(Dog dog) {
        shelterDogs.put(dog.getId(), dog);
    }

    public Dog retrieveDogById(int id) {
        return shelterDogs.get(id);
    }

    public void removeDogById(int id) {
        shelterDogs.remove(id);
    }
}

