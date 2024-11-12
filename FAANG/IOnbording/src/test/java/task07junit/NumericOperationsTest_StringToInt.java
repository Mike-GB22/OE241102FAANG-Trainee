package task07junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumericOperationsTest_StringToInt {

    NumericOperations calc;
    @BeforeEach
    void setUp(){
        calc = new NumericOperations();
    }
    @Test
    @DisplayName("Positive. Простой")
    void stringToInt_PositiveEinFach() {
        //Arrange
        Integer element1 = 10;
        Integer element2 = 20_000;
        Integer element3 = 300_000_000;

        //Act
        //Assert
        assertEquals(element1, calc.stringToInt(element1.toString()));
        assertEquals(element2, calc.stringToInt(element2.toString()));
        assertEquals(element3, calc.stringToInt(element3.toString()));

    }

    @ParameterizedTest
    @DisplayName("Positive. Параметризированный")
    @ValueSource(
            ints = {1, 2, 3, 4, 5, 100, 1_000_000_000, 0, -1 , -2, -3, -4, -5, -100, -1_000_000_000})
    void stringToInt_PositiveParams(Integer expectedResult) {
        //Arrange
        String stringToInt = expectedResult.toString();

        //Act
        int result = calc.stringToInt(stringToInt);

        //Assert
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @DisplayName("Negative. Параметризированный")
    @ValueSource(
            strings = {"_1", "a2", " 3", "4_", "5-", "6 ", " 7 ", "", "8a"})
    void stringToInt_NegativeParams(String stringToThrow) {
        //Arrange
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> calc.stringToInt(stringToThrow));
    }

    @ParameterizedTest
    @DisplayName("Negative. Пустая строка и null")
    @NullAndEmptySource
    void stringToInt_NegativeNullAndEmpty(String in) {
        //Arrange
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> calc.stringToInt(in));
    }
}