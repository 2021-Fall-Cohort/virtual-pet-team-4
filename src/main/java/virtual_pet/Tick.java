package virtual_pet;

public class Tick {
    private int tick = 0;

    public Tick(int tick) {
        this.tick = tick;
    }


    public int getTick() {
        return tick;
    }

    public static int tick() {
        int tick = 0;
        while (tick < 500)
            tick++;
        if (tick == 500) {
            tick = 0;
        }
        return tick;
    }


}
