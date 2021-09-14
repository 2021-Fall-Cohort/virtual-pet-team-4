package virtual_pet;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Interact with a VirtualPet object in this method
        System.out.println("Welcome to your very own Virtual Dog simulator");
        System.out.println("Please enter your Dog's name below: ");
        String dogName = scanner.nextLine();
        Dog dog1 = new Dog(dogName);
        dog1.tick();
        dog1.status();
    }

}
