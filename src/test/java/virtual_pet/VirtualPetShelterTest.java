package virtual_pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VirtualPetShelterTest {
    VirtualPetShelter underTest;
    Dog dog1;
    Dog dog2;

    @BeforeEach
    void setUp() {
        underTest = new VirtualPetShelter();
        dog1 = new Dog("Wrigley", "Female", "Lab", "Her", 1);
        dog2 = new Dog("Cam", "Female", "Lab", "Her", 2);
    }

    @Test
    void shouldCreateClassAndAddItsMap() {
        underTest.addDog(dog1);
        assertEquals("Wrigley", underTest.retrieveDogById(1).getName());
    }

    @Test
    void shouldReturnDogByKey() {
        underTest.addDog(dog1);
        underTest.addDog(dog2);
        assertEquals("Cam", underTest.retrieveDogById(2).getName());
    }

    @Test
    void shouldRemoveDogByKey() {
        underTest.addDog(dog1);
        underTest.addDog(dog2);
        underTest.removeDogById(dog2.getId());
        assertNull(underTest.retrieveDogById(2));
    }
}
