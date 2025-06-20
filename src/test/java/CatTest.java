package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    void getSoundShouldReturnMeow() {
        Predator predator = mock(Predator.class);
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldCallEatMeat() throws Exception {
        Predator predator = mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы"));

        Cat cat = new Cat(predator);
        List<String> food = cat.getFood();

        assertEquals(List.of("Животные", "Птицы"), food);
        verify(predator).eatMeat();
    }
}
