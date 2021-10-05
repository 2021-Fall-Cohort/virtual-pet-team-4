package virtual_pet;
import java.util.Random;

public class PersonalityGen {

    private int favoriteToy;
    Random rand = new Random();

    public PersonalityGen() {
        this.favoriteToy = favoriteToy;
    }

    public int getFavoriteToy() {
        favoriteToy = rand.nextInt(2);
        return favoriteToy;
    }
}
