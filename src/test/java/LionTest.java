package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    @Test
    void lionHasManeIfMale() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void lionHasNoManeIfFemale() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void throwsExceptionForInvalidSex() {
        Exception ex = assertThrows(Exception.class, () -> new Lion("X", new Feline()));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Птицы"));
        Lion lion = new Lion("Самец", (Feline) predatorMock);
        assertEquals(List.of("Птицы"), lion.getFood());
    }
}