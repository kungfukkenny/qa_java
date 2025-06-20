package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalParamTest {

    Animal animal = new Animal();

    @ParameterizedTest
    @CsvSource({
            "Травоядное,Трава|Различные растения",
            "Хищник,Животные|Птицы|Рыба"
    })
    void getFood_shouldReturnCorrectFoodList(String kind, String expectedCsv) throws Exception {
        List<String> expected = List.of(expectedCsv.split("\\|"));
        assertEquals(expected, animal.getFood(kind));
    }

    @ParameterizedTest
    @CsvSource({
            "Насекомоядное",
            "None"
    })
    void getFood_shouldThrowExceptionForUnknownKind(String kind) {
        Exception ex = assertThrows(Exception.class, () -> animal.getFood(kind));
        assertTrue(ex.getMessage().contains("Неизвестный вид животного"));
    }

}
