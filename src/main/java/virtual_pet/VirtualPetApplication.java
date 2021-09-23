package virtual_pet;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//
public class VirtualPetApplication {


    public static void main(String[] args) {
        VirtualPetApplication myApp = new VirtualPetApplication();
        myApp.game();
    }
    public void game() {
        Scanner scanner = new Scanner(System.in);

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
            Thread.sleep(3000);
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

        // Start the shelter off with 4 dogs
        VirtualPetShelter myShelter = new VirtualPetShelter();
        for (int i = 0; i < 4; i++) {
            myShelter.addDog(new Dog(nameGen.getName(), nameGen.getSex(), breedGen.getBreed(), nameGen.getPronoun(), i, nameGen.getAge()));
        }

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
//                    System.out.println(" ID   | Name ");
//                    for (int i = 0; i < myShelter.numberOfDogs(); i++) {
//                        myShelter.retrieveDogById(i).playList();
//                        myShelter.retrieveDogById(i).play();
//                    }
//                    System.out.println("Enter the id of the dog you'd like to play with:");

                    // Present user with list of dogs to choose from
                    // Retrieve that dog by Id? & play
                    break;
                case "2":
                    if (myShelter.numberOfDogs() == 0 ) {
                        System.out.println("You don't have any dogs to give water to!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.water();
                        currentDog.tick();
                    }
                    break;
                case "3":
                    if (myShelter.numberOfDogs() == 0 ) {
                        System.out.println("You don't have any dogs to feed!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.feed();
                        currentDog.tick();
                    }
                    break;
                case "4":
                    if (myShelter.numberOfDogs() == 0 ) {
                        System.out.println("You don't have any dogs!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    System.out.println("Name  | Hunger | Thirst | Boredom");
                    System.out.println("----------------------------------");
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.tick();
                        System.out.println(currentDog.status());
                    }
                    break;
                case "5":
                    if (myShelter.numberOfDogs() == 0 ) {
                        System.out.println("You don't have any dogs!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    System.out.println("Name  | Age | Gender | Breed");
                    System.out.println("-----------------------------------");
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.tick();
                        System.out.println(currentDog.info());
                    }
                    break;
                case "6":
                    // Present user with a list of all their dogs (probably more similar to the info screen
                    if (myShelter.numberOfDogs() == 0 ) {
                        System.out.println("You don't have any dogs to give away!");
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    System.out.println(" ID   | Name   |  Age   |  Breed ");
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.tick();
                        System.out.println(currentDog.adopt());
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
                    for(Dog currentDog: myShelter.getDogs()) {
                        currentDog.tick();
                    }
                    }
            }
            while (isRunning) ;
    }

    public void checkQuit(String choice) {
        if (choice.equalsIgnoreCase("quit")) {
            System.out.println("Thank you for playing Virtual Pet Simulator");
            System.out.println("Created by William Robson and Josh Wright");
            System.exit(0);
        }
    }
}


