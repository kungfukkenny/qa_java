package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FelineParamTest {

    Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 100})
    void getKittens_shouldReturnSameNumber(int kittens) {
        assertEquals(kittens, feline.getKittens(kittens));
    }
}