import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class CompanionTest {

    @Test
    public void testCompanion() {
        Companion c = new Dog("Buddy");
        assertEquals(c.getFriendlyName(), "Buddy");
    }

    @Test
    public void testAddTrick() {
        Companion c = new Dog("Buddy");
        Trick t = new Trick("Sit");
        assert (c.addTrick(t));
        assertEquals(c.trickCount(), 1);
    }


}
