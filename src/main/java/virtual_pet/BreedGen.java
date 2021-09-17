package virtual_pet;

import java.util.Random;

public class BreedGen {
    private static String breed;
    private String[] breedList = new String[10];

    public BreedGen(){
        this.breed =breed;
        Random rand = new Random();
        int r = rand.nextInt(10);

        breedList[0] = "Bulldog";
        breedList[1] = "Poodle";
        breedList[2] = "Mastiff";
        breedList[3] = "Chow chow";
        breedList[4] = "Pug";
        breedList[5] = "Golden retriever";
        breedList[6] = "Beagle";
        breedList[7] = "Great dane";
        breedList[8] = "Huskey";
        breedList[9] = "Shiba inu";

        breed = breedList[r];

    }
    public String getBreed() {
        return breed;
    }

}
