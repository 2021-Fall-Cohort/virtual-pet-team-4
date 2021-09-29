package virtual_pet;
import java.util.HashMap;

public class VirtualPetShelter {
    private HashMap<Integer, VirtualPet> shelterPets = new HashMap<Integer, VirtualPet>();

    public VirtualPetShelter() {
        shelterPets = new HashMap<Integer, VirtualPet>( );
    }

    public void addPet(VirtualPet pet) {
        shelterPets.put(pet.getId(), pet);
    }

    public VirtualPet retrievePetById(int id) {
        return shelterPets.get(id);
    }

    public void removePetById(int id) {
        shelterPets.remove(id);
    }

    public int numberOfPets() {
        return shelterPets.size();
    }

    public VirtualPet[] getPets() {
        return shelterPets.values().toArray(new VirtualPet[0]);
    }
}

