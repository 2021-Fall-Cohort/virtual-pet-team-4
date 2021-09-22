package virtual_pet;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;
//
public class VirtualPetApplication {


    public static void main(String[] args) {
        VirtualPetApplication myApp = new VirtualPetApplication();
        myApp.game();
    }
    public void game() {
        Scanner scanner = new Scanner(System.in);

        // First Run (Establish The Shelter)
        // Instantiate the HashMap
        // Generate 4 dogs at random
        // Add the 4 dogs to the shelter hashmap
        // Enter the game loop, and prompt the user with their status

        System.out.println("                                                                                     \n" +
                "@@@@@@@       @@@@@@       @@@@@@@@      @@@@@@@@      @@@@@@        @@@@@@      \n" +
                "@@@@@@@@     @@@@@@@@     @@@@@@@@@     @@@@@@@@@     @@@@@@@@      @@@@@@@      \n" +
                "@@!  @@@     @@!  @@@     !@@           !@@           @@!  @@@      !@@          \n" +
                "!@!  @!@     !@!  @!@     !@!           !@!           !@!  @!@      !@!          \n" +
                "@!@  !@!     @!@  !@!     !@! @!@!@     !@! @!@!@     @!@  !@!      !!@@!!       \n" +
                "!@!  !!!     !@!  !!!     !!! !!@!!     !!! !!@!!     !@!  !!!       !!@!!!      \n" +
                "!!:  !!!     !!:  !!!     :!!   !!:     :!!   !!:     !!:  !!!           !:!     \n" +
                ":!:  !:!     :!:  !:!     :!:   !::     :!:   !::     :!:  !:!          !:!      \n" +
                " :::: ::     ::::: ::      ::: ::::      ::: ::::     ::::: ::      :::: ::      \n" +
                ":: :  :       : :  :       :: :: :       :: :: :       : :  :       :: : :       \n" +
                "                                                                                      ");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        NameGen nameGen = new NameGen();
        BreedGen breedGen = new BreedGen();
        String randName = nameGen.getName();
        String randBreed = breedGen.getBreed();
        System.out.println("Welcome to the Virtual Pet Shelter simulator");
        String choice = "";

        Boolean isRunning = true;

        // If the user chooses to have a random name, grab the random name and set the corresponding gender

//        if (dogName.toLowerCase().contains("random")) {
//            dogName = randName;
//            dogBreed = randBreed;
//            if (nameGen.getSex().equalsIgnoreCase("male")) {
//                dogSex = "Male";
//                dogPronoun = "His";
//            } else if (nameGen.getSex().equalsIgnoreCase("female")) {
//                dogSex = "Female";
//                dogPronoun = "Her";
//            }
//            System.out.println("Wow! You got a " + dogBreed + "! " + dogPronoun + " name is " + dogName + " :)");
//        } else {
//            System.out.println("Enter your Dog's sex below: ");
//            dogSex = scanner.nextLine();
//            System.out.println("Enter your dogs breed below: ");
//            dogBreed = scanner.nextLine();
//            if (dogSex.equalsIgnoreCase("male")) {
//                dogPronoun = "His";
//            }
//            if (dogSex.equalsIgnoreCase("female")) {
//                dogPronoun = "Her";
//            }
//        }
        VirtualPetShelter myShelter = new VirtualPetShelter();
        for (int i = 0; i < 4; i++) {
            myShelter.addDog(new Dog(nameGen.getName(), nameGen.getSex(), breedGen.getBreed(), nameGen.getPronoun(), i, nameGen.getAge()));
        }

        // When we go to create dogs later, we can run shelterDogs.numberOfDogs() + 1 to get the future IDs

//        Boolean dogLiving = dog1.getDogIsAlive();
//        Boolean dogDiedOld = dog1.getDogDiedOld();

        // Game Loop //
        do {
            // Pull all dogs from the hashmap and present to user
            // Present the user with a picture / status of their shelter
            // What would you like to do with your dogs?
//            dog1.dogNeutral();
            System.out.println("What would you like to do with your pets?");
            System.out.println("1. Play with a pet"); // Prompt the user to select between their dogs
            System.out.println("2. Give pets something to drink"); // Prompt the user to select drinks for all their dogs
            System.out.println("3. Give pets some food"); // Prompt the user to select food for all their dogs
            System.out.println("4. Get your pets' current status"); // Provide the user with status after tick
            System.out.println("5. Get your pets' info"); // Provide the user with a table of all dog's info
            System.out.println("6. Adopt a dog out");
            System.out.println("7. Admit a dog in");
            System.out.println("Type quit to quit");
            choice = scanner.nextLine();
            checkQuit(choice);
            switch (choice) {
                case "1":
                    // Present user with list of dogs to choose from
                    // Retrieve that dog by Id? & play
                    break;
                case "2":
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).water();
                        myShelter.retrieveDogById(i).tick();
                    }
                    break;
                case "3":
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).feed();
                        myShelter.retrieveDogById(i).tick();
                    }
                    break;
                case "4":
                    System.out.println("Name  | Hunger | Thirst | Boredom");
                    System.out.println("----------------------------------");
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).tick();
                        myShelter.retrieveDogById(i).status();
                    }
                    break;
                case "5":
                    System.out.println("Name  | Age | Gender | Breed");
                    System.out.println("-----------------------------------");
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).tick();
                        myShelter.retrieveDogById(i).info();
                    }
                    break;
                case "6":
                    // Present user with a list of all their dogs (probably more similar to the info screen
                    System.out.println(" ID   | Name   |  Age   |  Breed ");
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).tick();
                        myShelter.retrieveDogById(i).adopt();
                    }
                    System.out.println("Enter the ID of the dog you want to adopt out");
                    Scanner adoptionScanner = new Scanner(System.in);
                    myShelter.removeDogById(adoptionScanner.nextInt());
                    // But with more information from the status screen
                    // Whichever they choose gets myShelter.remove()
                    // Show ASCII of dog leaving with family
                    break;
                case "7":
                    // Present the user with their new randomly generated dog
                    // Add the new dog to the HashMap
                    myShelter.addDog(new Dog(nameGen.getName(), nameGen.getSex(), breedGen.getBreed(), nameGen.getPronoun(), (myShelter.numberOfDogs() + 1), nameGen.getAge()));
                    break;
                default:
                    System.out.println("Your pets get nothing >:(");
                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
                        myShelter.retrieveDogById(i).tick();
                        break;
                    }
//            dogLiving = dog1.getDogIsAlive();
//            dogDiedOld = dog1.getDogDiedOld();
            }
        }
            while (isRunning) ;
//        if (dogDiedOld) {
//            System.out.println("You gave your dog " + dogName + " a full life, you win!");
//            System.out.println("Thank you for playing Dog Simulator");
//            System.out.println("Created by Josh Wright and William Robson");
//        } else {
//            System.out.println("Oh no! " + dogName + " has died :( ");
//            System.out.println("Maybe you'll do better with the next one!");
//            System.out.println("Thank you for playing Dog Simulator");
//            System.out.println("Created by Josh Wright and William Robson");
//        }
    }

    public void checkQuit(String choice) {
        if (choice.equalsIgnoreCase("quit")) {
            System.out.println("Thank you for playing Virtual Pet Simulator");
            System.out.println("Created by William Robson and Josh Wright");
            System.exit(0);
        }
    }
}


