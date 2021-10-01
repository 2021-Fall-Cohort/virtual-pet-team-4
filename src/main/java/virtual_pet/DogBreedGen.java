package virtual_pet;

import java.util.Random;

public class DogBreedGen {
    private static String dogBreed;
    private String[] dogBreedList = new String[10];

    public DogBreedGen() {
        this.dogBreed = "NoBreed";
    }
    public String getDogBreed() {

        Random rand = new Random();
        int r = rand.nextInt(10);

        dogBreedList[0] = "Bulldog";
        dogBreedList[2] = "Mastiff";
        dogBreedList[3] = "Chow Chow";
        dogBreedList[4] = "Pug";
        dogBreedList[5] = "Golden Retriever";
        dogBreedList[6] = "Beagle";
        dogBreedList[7] = "Great Dane";
        dogBreedList[1] = "Poodle";
        dogBreedList[8] = "Huskey";
        dogBreedList[9] = "Shiba Inu";
        dogBreed = dogBreedList[r];

        return dogBreed;
    }

}
