
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HorseTest {

    @Test
    void constructorNullAssertion() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(null, 1, 1));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void testConstrOnWhiteSpace(String argument) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(argument, 1, 1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void testConstrOnNegativeNum() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("argument", -1, 1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void testConstrOnNegativeNum2() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("argument", 1, -1));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getNameTest() {
        Horse horse = new Horse("arg", 1, 2);
        assertEquals("arg", horse.getName());
    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("arg", 1, 2);
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("arg", 1, 2);
        assertEquals(2, horse.getDistance());

        Horse horse2 = new Horse("arg", 2);
        assertEquals(0, horse2.getDistance());
    }

    @Test
    void moveTest() {
        try (MockedStatic<Horse> mockHorse = Mockito.mockStatic(Horse.class)) {
            Horse h = new Horse("a", 1, 1);
            h.move();
            mockHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }



    }
    @Test
    void moveTestCheckExpression () {
        try (MockedStatic<Horse> mockHorse = Mockito.mockStatic(Horse.class)) {
            Horse h = new Horse("a", 1, 4);
            h.move();
            mockHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.0);
            assertEquals(35.0, h.getDistance()+31*Horse.getRandomDouble(0.2, 0.9));
        }
    }

}
