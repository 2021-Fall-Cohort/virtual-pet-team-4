package virtual_pet;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Build Your Dog / Header

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

        NameGen nameGen = new NameGen();
        String randName = nameGen.getName();
        System.out.println("Welcome to your very own Virtual Dog simulator");
        System.out.println("Enter your dog's name below or type Random to Randomize: ");
        String dogName = scanner.nextLine();
        String dogSex = "";

        // If the user chooses to have a random name, grab the random name and set the corresponding gender

        if (dogName.toLowerCase().contains("random")) {
            dogName = randName;
            System.out.println("Your dogs name will be: " + randName);
            if (nameGen.getSex().equalsIgnoreCase("male") ) {
                dogSex = "Male";
                System.out.println("He is male");
            }
            else if (nameGen.getSex().equalsIgnoreCase("female")) {
                dogSex = "Female";
                System.out.println("She is female");
            }
        } else {
            System.out.println("Enter your Dog's sex below: ");
            dogSex = scanner.nextLine();
        }

        System.out.println("Enter your dogs breed below: ");
        String dogBreed = scanner.nextLine();
        Dog dog1 = new Dog(dogName, dogSex, dogBreed);
        Boolean dogLiving = dog1.getDogIsAlive();

        // Game Loop //
        do {
            dog1.dogNeutral();
            System.out.println("What would you like to do with your dog " + dogName + "?");
            System.out.println("1. Play with " + dogName);
            System.out.println("2. Give " + dogName + " water");
            System.out.println("3. Give " + dogName + " food");
            System.out.println("4. Get " + dogName + "'s current status");
            System.out.println("5. Get " + dogName + "'s info");
            System.out.println("Type quit to quit");
            String choice = scanner.nextLine();
            checkQuit(choice);
            switch (choice) {
                case "1":
                    dog1.playWithDog();
                    dog1.tick();
                    dog1.status();
                    dog1.getOutputMessage();
                    break;
                case "2":
                    dog1.waterDog();
                    dog1.dogDrinking();
                    dog1.tick();
                    dog1.status();
                    break;
                case "3":
                    dog1.feedDog();
                    dog1.tick();
                    dog1.status();
                    dog1.getOutputMessage();
                    break;
                case "4":
                    dog1.tick();
                    dog1.status();
                    break;
                case "5":
                    dog1.info();
                    break;
                default:
                    System.out.println(dogName + " gets nothing >:(");
                    dog1.tick();
                    dog1.status();
                    break;
            }
            dogLiving = dog1.getDogIsAlive();
        }
        while (dogLiving);
        System.out.println("Oh no! " + dogName + " has died :( ");
        System.out.println("Maybe you'll do better with the next one!");
        System.out.println("Thank you for playing Dog Simulator");
    }

        public static void checkQuit(String userInput) {
            if(userInput.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for playing Dog Simulator");
                System.exit(0);
            }
        }
}

