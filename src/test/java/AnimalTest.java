package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    Animal animal = new Animal();

    @Test
    void getFoodForHerbivore() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    void getFoodForPredator() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    void getFoodForUnknownThrows() {
        Exception ex = assertThrows(Exception.class, () -> animal.getFood("Другое"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
    }

    @Test
    void getFamilyReturnsCorrectText() {
        assertTrue(animal.getFamily().contains("семейств"));
    }
}