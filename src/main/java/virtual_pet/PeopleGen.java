package virtual_pet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public class PeopleGen {

    private String personFirstName = "none";
    private String personLastName = "none";
    private int personAge;

    public PeopleGen() {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this. personAge = personAge;
        Random rand = new Random();

        /// First name gen
        int lineNumber1 = rand.nextInt( 1999);
        try{
            String line1 = Files.readAllLines(Paths.get("NamesFile/male names list.txt")).get(lineNumber1);
            personFirstName = line1;
        }
        catch(IOException e){
            System.out.println(e);
        }
        /// Last name gen
        int lineNumber2 = rand.nextInt( 995);
        try{
            String line2 = Files.readAllLines(Paths.get("NamesFile/lastNamesList.txt")).get(lineNumber2);
            personLastName = line2;
        }
        catch(IOException e){
            System.out.println(e);
        }
        /// Age gen
        personAge = rand.nextInt(65);
    }
    // Returns a person
    public String getPerson() {
        return "First Name: " + personFirstName + " Last Name: " + personLastName + " Age: " + personAge;
    }
}
