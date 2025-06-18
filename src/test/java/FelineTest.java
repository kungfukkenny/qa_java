package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    void eatMeatReturnsMeatList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCats() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensDefaultIsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensReturnsCorrectNumber() {
        assertEquals(3, feline.getKittens(3));
    }
}