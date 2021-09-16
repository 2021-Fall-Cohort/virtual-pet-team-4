package virtual_pet;
import java.time.LocalTime;
public class Clock {

    static LocalTime clock = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());

    public static Clock getTime() {

        System.out.println("                               Time: " + clock);
        return null;
    }

}
