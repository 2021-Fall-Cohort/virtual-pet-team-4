package virtual_pet;

import java.util.Random;

public class BreedGen {
    private static String breed;
    private String[] breedList = new String[10];

    public BreedGen() {
        this.breed = "NoBreed";
    }
    public String getBreed() {

        Random rand = new Random();
        int r = rand.nextInt(10);

        breedList[0] = "Bulldog";
        breedList[1] = "Poodle";
        breedList[2] = "Mastiff";
        breedList[3] = "Chow Chow";
        breedList[4] = "Pug";
        breedList[5] = "Golden Retriever";
        breedList[6] = "Beagle";
        breedList[7] = "Great Dane";
        breedList[8] = "Huskey";
        breedList[9] = "Shiba Inu";
        breed = breedList[r];

        return breed;
    }

}
