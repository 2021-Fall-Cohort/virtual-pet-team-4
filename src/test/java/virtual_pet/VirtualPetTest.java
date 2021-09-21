package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetTest {
    private Dog underTest;

    @BeforeEach
    void setUp() {
        underTest = new Dog ("Wrigley", "Female", "Lab", "Her", 1);
    }

    @Test
    public void doesDogClassCreate() {
        Dog underTest = new Dog("Wrigley", "Female", "Lab", "Her", 1);
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
}
