package virtual_pet;

import java.util.ArrayList;

public class AdoptionList {

    private ArrayList<String> list = new ArrayList<String>();

    public void getList() {
        for (String current: list) {
            System.out.println(current);
        }
    }
    public void add(String toAdoptionList) {
        list.add(toAdoptionList);
    }
}
