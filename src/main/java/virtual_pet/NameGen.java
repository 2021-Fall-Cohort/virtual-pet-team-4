package virtual_pet;
import java.util.Random;
//

public class NameGen {
    private static String[] maleNameList = new String[10];
    private static String[] femaleNameList = new String[10];
    private static String name;
    private static String gS;

    public NameGen() {
        this.name = "NONAME";
    }
    public String getName() {
        Random rand = new Random();
        int r = rand.nextInt(20);
        int r2 = rand.nextInt(10);
        maleNameList[0] = "Charlie";
        maleNameList[1] = "Max";
        maleNameList[2] = "Buddy";
        maleNameList[3] = "Milo";
        maleNameList[4] = "Archie";
        maleNameList[5] = "Ollie";
        maleNameList[6] = "Oscar";
        maleNameList[7] = "Teddy";
        maleNameList[8] = "Leo";
        maleNameList[9] = "Shepard";

        femaleNameList[0] = "Bella";
        femaleNameList[1] = "Luna";
        femaleNameList[2] = "Coco";
        femaleNameList[3] = "Ruby";
        femaleNameList[4] = "Molly";
        femaleNameList[5] = "Frankie";
        femaleNameList[6] = "Daisy";
        femaleNameList[7] = "Rosie";
        femaleNameList[8] = "Lucy";
        femaleNameList[9] = "Claire";

        if (r <= 10) {
            name = maleNameList[r];
            gS = "Male";
        }
        else if (r >= 11) {
            name = femaleNameList[r2];
            gS = "Female";
        }
        return name;
    }
    public String getSex() {
        return gS;
    }
}
