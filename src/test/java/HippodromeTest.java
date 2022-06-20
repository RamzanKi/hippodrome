import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class HippodromeTest {

    @Test
    void constructorNullAssertion() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void constructorAssertion() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorsesTest() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("a", 13, 1));
        horses.add(new Horse("q", 1, 1));
        horses.add(new Horse("w", 12, 1));
        horses.add(new Horse("e", 1, 1));
        horses.add(new Horse("r", 1312, 1));
        horses.add(new Horse("t", 1, 331));
        horses.add(new Horse("y", 3, 1));
        horses.add(new Horse("u", 11, 1));
        horses.add(new Horse("s", 123, 123));
        horses.add(new Horse("aa", 1, 1));
        horses.add(new Horse("da", 123, 1));
        horses.add(new Horse("weq", 1, 1));
        horses.add(new Horse("sax", 1, 1));
        horses.add(new Horse("dgg", 1, 6));
        horses.add(new Horse("l", 1, 85));
        horses.add(new Horse("k", 312, 1));
        horses.add(new Horse("j", 1, 1));
        horses.add(new Horse("h", 1, 1));
        horses.add(new Horse("g", 1, 1));
        horses.add(new Horse("m", 1, 23));
        horses.add(new Horse("b", 1, 1));
        horses.add(new Horse("v", 123, 1));
        horses.add(new Horse("c", 1, 1));
        horses.add(new Horse("x", 1, 1));
        horses.add(new Horse("z", 1, 1));
        horses.add(new Horse("ahfg", 1, 1));
        horses.add(new Horse("hfgh", 1, 1));
        horses.add(new Horse("erte", 1, 1));
        horses.add(new Horse("khs", 1, 1));
        horses.add(new Horse("fffff", 1, 1));

        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void moveTest() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (int i = 0; i < 49; i++) {
            Mockito.verify(horses.get(i)).move();
        }
    }

    @Test
    void getWinnerTest() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("a", 13, 311));
        horses.add(new Horse("q", 1, 133));
        horses.add(new Horse("w", 12, 1));
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(311,  hippodrome.getWinner().getDistance());
    }

}
