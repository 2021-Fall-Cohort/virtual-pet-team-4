package virtual_pet;
import java.util.Random;
//

public class NameGen {
    private static String[] maleNameList = new String[10];
    private static String[] femaleNameList = new String[10];
    private static String name;
    private static String gS;
    private String pronoun;
    private int age;

    public NameGen() {
        this.name = "NONAME";
    }
    public String getName() {
        Random rand = new Random();
        int r = rand.nextInt(20);
        int r2 = rand.nextInt(10);
        maleNameList[0] = "James";
        maleNameList[1] = "Maxie";
        maleNameList[2] = "Buddy";
        maleNameList[3] = "Jaxon";
        maleNameList[4] = "Wyatt";
        maleNameList[5] = "Ollie";
        maleNameList[6] = "Oscar";
        maleNameList[7] = "Teddy";
        maleNameList[8] = "Aiden";
        maleNameList[9] = "Chase";

        femaleNameList[0] = "Bella";
        femaleNameList[1] = "Emily";
        femaleNameList[2] = "Naomi";
        femaleNameList[3] = "Quinn";
        femaleNameList[4] = "Molly";
        femaleNameList[5] = "Sofia";
        femaleNameList[6] = "Daisy";
        femaleNameList[7] = "Rosie";
        femaleNameList[8] = "Lucie";
        femaleNameList[9] = "Hazel";

        if (r <= 10) {
            name = maleNameList[r];
            gS = "M";
            pronoun = "His";
            age = r2;
        }
        else if (r >= 11) {
            name = femaleNameList[r2];
            gS = "F";
            pronoun = "Her";
            age = r2;
        }
        return name;
    }
    public String getSex() {
        return gS;
    }

    public String getPronoun() {
        return pronoun;
    }

    public int getAge() {
        return age;
    }
}
