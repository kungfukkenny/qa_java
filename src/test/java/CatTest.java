package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    @Test
    void getSoundShouldReturnMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldCallEatMeat() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Рыба"));
        Cat cat = new Cat((Feline) predatorMock); // Убрано приведение типа
        assertEquals(List.of("Рыба"), cat.getFood());
    }
}