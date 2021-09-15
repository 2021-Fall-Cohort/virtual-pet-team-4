package virtual_pet;
import java.sql.SQLOutput;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        // Build Your Dog
        System.out.println("Welcome to your very own Virtual Dog simulator");
        System.out.println("Please enter your Dog's name below: ");
        String dogName = scanner.nextLine();
        Dog dog1 = new Dog(dogName);

        // Game Loop
        do {
            System.out.println("What would you like to do with your dog " + dogName);
            System.out.println("1. Play with dog");
            System.out.println("2. Give dog water");
            System.out.println("3. Give dog food");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    dog1.playWithDog();
                    System.out.println("Let's play with the dog");
                    dog1.tick();
                    dog1.status();
                    break;
                case 2:
                    dog1.waterDog();
                    System.out.println("Let's give our dog some water");
                    dog1.tick();
                    dog1.status();
                    break;
                case 3:
                    dog1.feedDog();
                    System.out.println("Let's feed our dog");
                    dog1.tick();
                    dog1.status();
                    break;
                default:
                    System.out.println("Our dog gets nothing >:(");
                    dog1.tick();
                    dog1.status();
                    break;
            }
        }
        while (running);
    }
}



        /*dog1.tick();
        dog1.tick();
        dog1.tick();
        dog1.tick();
        // while(running) {
            dog1.tick();
            dog1.status();
        //} */

