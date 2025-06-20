package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LionParamTest {

    @ParameterizedTest
    @CsvSource({
        "Самец,true",
        "Самка,false"
    })
    void lionHasManeDependantOnSex(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expected, lion.doesHaveMane());
    }

    @ParameterizedTest
    @CsvSource({
            "Мужик,Используйте допустимые значения пола животного - самец или самка",
            "Lioness,Используйте допустимые значения пола животного - самец или самка"
    })
    void lionConstructor_shouldThrowExceptionForInvalidSex(String sex, String expectedMessage) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, new Feline()));
        assertEquals(expectedMessage, exception.getMessage());
    }
}