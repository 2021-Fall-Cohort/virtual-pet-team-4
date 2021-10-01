package virtual_pet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Formatter;
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        NameGen nameGen = new NameGen();
        DogBreedGen dogBreedGen = new DogBreedGen();
        CatBreedGen catBreedGen = new CatBreedGen();
        PersonalityGen personalityGen = new PersonalityGen();

        String randName = nameGen.getName();
        System.out.println("Welcome to the Virtual Pet Shelter simulator");
        String choice = "";
        Boolean isRunning = true;
        Boolean idPresent = false;

        // Start the shelter off with 4 pets, one of each type
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.addPet(new OrganicDog(nameGen.getName(), nameGen.getSex(), dogBreedGen.getDogBreed(), nameGen.getPronoun(), nameGen.getAge(), 0, personalityGen.getFavoriteFood(),personalityGen.getFavoriteToy()));
        myShelter.addPet(new OrganicCat(nameGen.getName(), nameGen.getSex(), catBreedGen.getCatBreed(), nameGen.getPronoun(), nameGen.getAge(), 1,personalityGen.getFavoriteFood(),personalityGen.getFavoriteToy()));
        myShelter.addPet(new RoboticDog(nameGen.getName(), nameGen.getSex(), dogBreedGen.getDogBreed(), nameGen.getPronoun(), nameGen.getAge(), 2,personalityGen.getFavoriteFood(),personalityGen.getFavoriteToy()));
        myShelter.addPet(new RoboticCat(nameGen.getName(), nameGen.getSex(), catBreedGen.getCatBreed(), nameGen.getPronoun(), nameGen.getAge(), 3,personalityGen.getFavoriteFood(),personalityGen.getFavoriteToy()));

        // Game Loop //
        do {
            // Pull all dogs from the hashmap and present to user
            // Present the user with a picture / status of their shelter
            // What would you like to do with your dogs?
            System.out.println("What would you like to do with your pets?");
            System.out.println("1. Play with a pet"); // Prompt the user to select between their dogs
            System.out.println("2. Give pets something to drink"); // Prompt the user to select drinks for all their dogs
            System.out.println("3. Give pets some food"); // Prompt the user to select food for all their dogs
            System.out.println("4. Get your pets' current status"); // Provide the user with status after tick
            System.out.println("5. Get your pets' info"); // Provide the user with a table of all dog's info
            System.out.println("6. Adopt a pet out");
            System.out.println("7. Admit a pet in");
            System.out.println("8. Clean cages / litterboxes");
            System.out.println("9. Take pets for a walk");
            System.out.println("Type quit to quit");
            choice = scanner.nextLine();
            checkQuit(choice);
            switch (choice) {
                case "1":
                    clearScreen();
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets to play with!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    String interactionFormat = "| %-5d | %-10s  | %-5d  | %-20s  |%n";
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    System.out.format("| ID    |    Name     |  Age   |        Breed          |%n");
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        System.out.format(interactionFormat, currentPet.getId(), currentPet.getName(), currentPet.getAge(), currentPet.getBreed());
                        currentPet.tick();
                    }
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    System.out.println(" ");
                    System.out.println("Enter the ID of the pet you want to play with");
                    Scanner playScanner = new Scanner(System.in);
                    int petToPlayId = playScanner.nextInt();
                    idPresent = false;
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        int currentId = currentPet.getId();
                        if (currentId == petToPlayId) {
                            idPresent = true;
                        }
                    }
                    if (!idPresent) {
                        System.out.println("That pet doesn't even exist!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    myShelter.retrievePetById(petToPlayId).play();
                    break;
                case "2":
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets to give water to!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        currentPet.water();
                        currentPet.tick();
                    }
                    break;
                case "3":
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets to feed!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        if (currentPet instanceof OrganicPet) {
                            ((OrganicPet) currentPet).feed();
                        }
                        currentPet.tick();
                    }
                    break;
                case "4":
                    clearScreen();
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    String organicDogFormat = "| %-10s |   %-5d|   %-5d|   %-5d |       %-5d      |       %-5d    |%n";
                    System.out.format("+------------------------+----------------------+----------------------------+%n");
                    System.out.format("|                          Organic Dogs' Status                              |%n");
                    System.out.format("+------------+--------+--------+---------+------------------+----------------+%n");
                    System.out.format("| Name       | Hunger | Thirst | Boredom | Cage Cleanliness | Bathroom Needs |%n");
                    System.out.format("+------------+--------+--------+---------+------------------+----------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        currentPet.statusCheck();
                        if (currentPet instanceof OrganicDog) {
                            System.out.format(organicDogFormat, currentPet.getName(), ((OrganicPet) currentPet).getHunger(), currentPet.getThirstLevel(), currentPet.getBoredomLevel(),
                                    ((OrganicDog) currentPet).getCageCleanliness(), ((OrganicPet) currentPet).getBathroomNeeds());
                            currentPet.tick();
                        }
                    }
                    System.out.format("+------------+--------+--------+---------+------------------+----------------+%n");
                    System.out.println(" ");
                    String organicCatFormat = "| %-10s |   %-5d|   %-5d|   %-5d |          %-5d        |       %-5d    |%n";
                    System.out.format("+----------------------------+----------------------+-----------------------------+%n");
                    System.out.format("|                              Organic Cats' Status                               |%n");
                    System.out.format("+------------+--------+--------+---------+-----------------------+----------------+%n");
                    System.out.format("| Name       | Hunger | Thirst | Boredom | Litterbox Cleanliness | Bathroom Needs |%n");
                    System.out.format("+------------+--------+--------+---------+-----------------------+----------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        if (currentPet instanceof OrganicCat) {
                            System.out.format(organicCatFormat, currentPet.getName(), ((OrganicPet) currentPet).getHunger(), currentPet.getThirstLevel(), currentPet.getBoredomLevel(),
                                    ((OrganicCat) currentPet).getLitterBoxCleanliness(), ((OrganicPet) currentPet).getBathroomNeeds());
                            currentPet.tick();
                        }
                    }
                    System.out.format("+------------+--------+--------+---------+-----------------------+----------------+%n");
                    System.out.println(" ");
                    String roboticDogFormat = "| %-10s |   %-5d|   %-5d |    %-5d  |          %-5d    |%n";
                    System.out.format("+--------------------+----------------------+-------------------+%n");
                    System.out.format("|                      Robotic Dogs' Status                     |%n");
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    System.out.format("| Name       | Thirst | Boredom | Oil Level | Maintenance Level |%n");
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        if (currentPet instanceof RoboticDog) {
                            System.out.format(roboticDogFormat, currentPet.getName(), currentPet.getThirstLevel(), currentPet.getBoredomLevel(),
                                    ((RoboticPet) currentPet).getOilLevel(), ((RoboticPet) currentPet).getMaintenanceLevel());
                            currentPet.tick();
                        }
                    }
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    System.out.println(" ");
                    String roboticCatFormat = "| %-10s |   %-5d|   %-5d |    %-5d  |          %-5d    |%n";
                    System.out.format("+--------------------+----------------------+-------------------+%n");
                    System.out.format("|                      Robotic Cats' Status                     |%n");
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    System.out.format("| Name       | Thirst | Boredom | Oil Level | Maintenance Level |%n");
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        if (currentPet instanceof RoboticCat) {
                            System.out.format(roboticCatFormat, currentPet.getName(), currentPet.getThirstLevel(), currentPet.getBoredomLevel(),
                                    ((RoboticPet) currentPet).getOilLevel(), ((RoboticPet) currentPet).getMaintenanceLevel());
                            currentPet.tick();
                        }
                    }
                    System.out.format("+------------+--------+---------+-----------+-------------------+%n");
                    System.out.println(" ");
                    break;
                case "5":
                    clearScreen();
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    String infoFormat = "| %-10s | %-5d  | %-5s  | %-20s  |%n";
                    System.out.format("+----------------+----------------+--------------------+%n");
                    System.out.format("|                  All Pets' Info                      |%n");
                    System.out.format("+------------+--------+--------+-----------------------+%n");
                    System.out.format("|  Name      |  Age   | Gender |         Breed         |%n");
                    System.out.format("+------------+--------+--------+-----------------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        System.out.format(infoFormat, currentPet.getName(), currentPet.getAge(), currentPet.getSex(), currentPet.getBreed());
                        currentPet.tick();
                    }
                    System.out.format("+------------+--------+--------+-----------------------+%n");
                    System.out.println(" ");
                    break;
                case "6":
                    PeopleGen peopleGen = new PeopleGen();
                    // Present user with a list of all their pets (probably more similar to the info screen
                    if (myShelter.numberOfPets() == 0) {
                        System.out.println("You don't have any pets to give away!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    interactionFormat = "| %-5d | %-10s  | %-5d  | %-20s  |%n";
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    System.out.format("| ID    |    Name     |  Age   |        Breed          |%n");
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        System.out.format(interactionFormat, currentPet.getId(), currentPet.getName(), currentPet.getAge(), currentPet.getBreed());
                        currentPet.tick();
                    }
                    System.out.format("+-------+-------------+--------+-----------------------+%n");
                    System.out.println(" ");
                    System.out.println("Enter the ID of the pet you want to adopt out");
                    Scanner adoptionScanner = new Scanner(System.in);
                    int petOutId = adoptionScanner.nextInt();
                    idPresent = false;
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        int currentId = currentPet.getId();
                        if (currentId == petOutId) {
                            idPresent = true;
                        }
                    }
                    if (!idPresent) {
                        System.out.println("That pet doesn't even exist!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    }
                    String petOut = myShelter.retrievePetById(petOutId).getName();
                    myShelter.removePetById(petOutId);
                    System.out.println(petOut + " has been adopted by " + peopleGen.getPersonFirstName() + " " + peopleGen.getPersonLastName() +
                            ". " + peopleGen.getPersonFirstName() + " is " + peopleGen.getPersonAge() + " years old, so they should have plenty of time for their new friend.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case "7":
                    // Prompt the user asking them which animal type they would like
                    // Then ask the user for name, sex, breed, and age
                    // Add the new pet to the Hashmap
                    System.out.println("What new animal would you like to admit?");
                    System.out.println("1. Organic Dog");
                    System.out.println("2. Organic Cat");
                    System.out.println("3. Robotic Dog");
                    System.out.println("4. Robotic Cat");
                    Scanner admitScanner = new Scanner(System.in);
                    int admitChoice = admitScanner.nextInt();
                    admitScanner.nextLine();
                    System.out.println("What would you like to name it?");
                    String admitName = admitScanner.nextLine();
                    System.out.println("What gender is your pet?");
                    String admitSex = admitScanner.nextLine();

                    String admitPronoun = "";
                    if (admitSex.equalsIgnoreCase("male")) {
                        admitPronoun = "His";
                        admitSex = "M";
                    } else if (admitSex.equalsIgnoreCase("female")) {
                        admitPronoun = "Her";
                        admitSex = "F";
                    }
                    System.out.println("What breed is your pet?");
                    String admitBreed = admitScanner.nextLine();
                    System.out.println("How old is your pet?");
                    int admitAge = admitScanner.nextInt();
                    System.out.println("Pick your pets favorite FOOD (numbers 0, 1, or 2) and press enter.");
                    int admitFavFood = admitScanner.nextInt();
                    System.out.println("Pick your pets favorite TOY (number 0, 1, or 2) and press enter.");
                    int admitFavToy = admitScanner.nextInt();
                    switch (admitChoice) {
                        case 1:
                            myShelter.addPet(new OrganicDog(admitName, admitSex, admitBreed, admitPronoun, (myShelter.numberOfPets() + 1), admitAge, admitFavFood, admitFavToy));
                            break;
                        case 2:
                            myShelter.addPet(new OrganicCat(admitName, admitSex, admitBreed, admitPronoun, (myShelter.numberOfPets() + 1), admitAge, admitFavFood, admitFavToy));
                            break;
                        case 3:
                            myShelter.addPet(new RoboticDog(admitName, admitSex, admitBreed, admitPronoun, (myShelter.numberOfPets() + 1), admitAge, admitFavFood, admitFavToy));
                            break;
                        case 4:
                            myShelter.addPet(new RoboticCat(admitName, admitSex, admitBreed, admitPronoun, (myShelter.numberOfPets() + 1), admitAge, admitFavFood, admitFavToy));
                            break;
                    }
                    System.out.println("Welcome " + admitName + " to our Pet Shelter!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case "8":
                    // option to clean cages / litter boxes
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        if (currentPet instanceof OrganicCat) {
                            ((OrganicCat) currentPet).cleanLitterBox();
                        }
                        if (currentPet instanceof OrganicDog) {
                            ((OrganicDog) currentPet).cleanCage();
                        }
                        currentPet.tick();
                    }
                    break;
                case "9":
                    // walk
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        currentPet.walk();
                        currentPet.tick();
                    }
                    break;
                default:
                    System.out.println("You made an invalid selection and now your pets get nothing >:(");
                    for (VirtualPet currentPet : myShelter.getPets()) {
                        currentPet.tick();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
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

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
    }
}


