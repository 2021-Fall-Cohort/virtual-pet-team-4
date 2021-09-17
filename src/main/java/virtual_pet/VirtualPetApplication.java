package virtual_pet;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        // Build Your Dog / Header

        System.out.println("                                                                                     \n" +
                "@@@@@@@       @@@@@@       @@@@@@@@      @@@@@@@@      @@@@@@         @@@@@@      \n" +
                "@@@@@@@@     @@@@@@@@     @@@@@@@@@     @@@@@@@@@     @@@@@@@@       @@@@@@@      \n" +
                "@@!  @@@     @@!  @@@     !@@           !@@           @@!  @@@       !@@          \n" +
                "!@!  @!@     !@!  @!@     !@!           !@!           !@!  @!@       !@!          \n" +
                "@!@  !@!     @!@  !@!     !@! @!@!@     !@! @!@!@     @!@  !@!       !!@@!!       \n" +
                "!@!  !!!     !@!  !!!     !!! !!@!!     !!! !!@!!     !@!  !!!        !!@!!!      \n" +
                "!!:  !!!     !!:  !!!     :!!   !!:     :!!   !!:     !!:  !!!            !:!     \n" +
                ":!:  !:!     :!:  !:!     :!:   !::     :!:   !::     :!:  !:!           !:!      \n" +
                " :::: ::     ::::: ::      ::: ::::      ::: ::::     ::::: ::       :::: ::      \n" +
                ":: :  :       : :  :       :: :: :       :: :: :       : :  :        :: : :       \n" +
                "                                                                                      ");

        System.out.println("Welcome to your very own Virtual Dog simulator");
        System.out.println("Enter your Dog's name below: ");
        // Clock clock = new Clock();    //call Clock.getTime(); to print "Time: HH:MM"   //or delete line
        String dogName = scanner.nextLine();
        Dog dog1 = new Dog(dogName);


        // Game Loop
        do {
            dog1.dogNeutral();
            System.out.println("What would you like to do with your dog " + dogName + "?");
            System.out.println("1. Play with " + dogName);
            System.out.println("2. Give " + dogName + " water");
            System.out.println("3. Give " + dogName + " food");
            System.out.println("4. Get " + dogName + "'s current status");
            System.out.println("Type quit to quit");
            String choice = scanner.nextLine();
            checkQuit(choice);
            switch (choice) {
                case "1":
                    dog1.playWithDog();
                    dog1.tick();
                    dog1.status();
                    break;
                case "2":
                    dog1.waterDog();
                    dog1.dogDrinking();
                    dog1.tick();
                    dog1.status();
                    break;
                case "3":
                    dog1.feedDog();
                    dog1.dogEating();
                    dog1.tick();
                    dog1.status();
                    break;
                case "4":
                    dog1.tick();
                    dog1.status();
                    break;
                default:
                    System.out.println(dogName + " gets nothing >:(");
                    dog1.tick();
                    dog1.status();
                    break;
            }
        }
        while (running);

    }

        public static void checkQuit(String userInput) {
            if(userInput.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for playing Dog Simulator");
                System.exit(0);
            }
        }
}

