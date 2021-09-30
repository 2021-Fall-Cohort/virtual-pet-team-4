package virtual_pet;
import java.util.Random;

public class PersonalityGen {

    private int favoriteFood;
    private int favoriteToy;
    Random rand = new Random();

    public PersonalityGen() {
        this.favoriteFood = favoriteFood;
        this.favoriteToy = favoriteToy;
    }

    public int getFavoriteFood() {
        favoriteFood = rand.nextInt(2);
        return favoriteFood;
    }

    public int getFavoriteToy() {
        favoriteToy = rand.nextInt(2);
        return favoriteToy;
    }
}
