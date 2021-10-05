package virtual_pet;

import java.util.Random;

public class CatBreedGen {
    private static String catBreed;
    private String[] catBreedList = new String[10];

    public CatBreedGen() {
        this.catBreed = "NoBreed";
    }

    public String getCatBreed() {

        Random rand = new Random();
        int r = rand.nextInt(10);

        catBreedList[0] = "Abyssinian";
        catBreedList[2] = "American Bobtail";
        catBreedList[3] = "American Shorthair";
        catBreedList[4] = "Bengal";
        catBreedList[5] = "Balinese";
        catBreedList[6] = "Chartreux";
        catBreedList[7] = "Birman";
        catBreedList[1] = "Cornish Rex";
        catBreedList[8] = "Havana Brown";
        catBreedList[9] = "Maine Coon";
        catBreed = catBreedList[r];

        return catBreed;
    }

}