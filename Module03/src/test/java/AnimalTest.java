import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class AnimalTest {

    @BeforeAll
    public static void setUp() {
        Taxonomy t1 = new Taxonomy("Dog", "Canis", "lupus", "Mamalia", "Carnivora", "Canidae", "Canis lupus", "nAnamalia");
        Animal a1 = new Animal(t1, "howl");
    }


    @Test
    public void testAnimalToString() {
        // assertEquals("I am a Canis, hear me "
    }
}
