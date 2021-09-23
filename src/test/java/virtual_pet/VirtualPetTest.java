package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetTest {
    private Dog underTest;

    @BeforeEach
    void setUp() {
        underTest = new Dog("Wrigley", "Female", "Lab", "Her", 1, 9);
    }

    @Test
    public void doesDogClassCreate() {
        Dog underTest = new Dog("Wrigley", "Female", "Lab", "Her", 1, 9);
    }

    @Test
    public void doesGetHungerReturn() {
        assertEquals(20, underTest.getHungerLevel());
    }

    @Test
    public void doesGetThirstReturn() {
        assertEquals(20, underTest.getThirstLevel());
    }

    @Test
    public void doesGetBoredomReturn() {
        assertEquals(20, underTest.getBoredomLevel());
    }

    @Test
    public void canDogBeFed() {
        underTest.feed();
        assertEquals(0, underTest.getHungerLevel());
    }

    @Test
    public void canDogBeWatered() {
        underTest.water();
        assertEquals(0, underTest.getThirstLevel());
    }

    @Test
    public void canDogBePlayedWith() {
        underTest.play();
        assertEquals(0, underTest.getBoredomLevel());
    }

    @Test
    public void canDogTick() {
        underTest.tick();
    }

    @Test
    public void canDogTickChangeHunger() {
        boolean hungerChange = false;
        int hungerBeforeTick = underTest.getHungerLevel();
        underTest.tick();
        if (hungerBeforeTick < underTest.getHungerLevel()) {
            hungerChange = true;
        }
        assertTrue(hungerChange);
    }

    @Test
    public void canDogTickChangeBoredom() {
        boolean boredomChange = false;
        int boredomBeforeTick = underTest.getBoredomLevel();
        underTest.tick();
        if (boredomBeforeTick < underTest.getBoredomLevel()) {
            boredomChange = true;
        }
        assertTrue(boredomChange);
    }

    @Test
    public void canDogTickChangeThirst() {
        boolean thirstChange = false;
        int thirstBeforeTick = underTest.getThirstLevel();
        underTest.tick();
        if (thirstBeforeTick < underTest.getThirstLevel()) {
            thirstChange = true;
        }
        assertTrue(thirstChange);
    }
}
