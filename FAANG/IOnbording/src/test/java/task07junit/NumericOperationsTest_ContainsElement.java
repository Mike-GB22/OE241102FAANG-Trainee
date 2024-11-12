package task07junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumericOperationsTest_ContainsElement {

    NumericOperations calc;
    @BeforeEach
    void setUp(){
        calc = new NumericOperations();
    }

    @Test
    @DisplayName("Positive. Массив 10 элементов")
    void containsElementPositiveEinfac() {
        //Arrange
        int element1 = 1;
        int element2 = 10;
        int element3 = 0;
        int[] inArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Act
        boolean result1 = calc.containsElement(inArray, element1);
        boolean result2 = calc.containsElement(inArray, element2);
        boolean result3 = calc.containsElement(inArray, element3);

        //Assert
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }

    @Test
    @DisplayName("Positive. Массив 0 элементов")
    void containsElementPositiveEinfachTWO() {
        //Arrange
        int element1 = 1;
        int[] inArray = new int[0];

        //Act
        boolean result1 = calc.containsElement(inArray, element1);

        //Assert
        assertFalse(result1);
    }

    @ParameterizedTest
    @DisplayName("Positive. Параметризированный тест")
    @MethodSource("arrayAndBooleanProvider")
    void containsElementPositiveParams(int[] inArray, int elementToCheck, boolean expectedResult){
        //Arrange
        //Act
        boolean result = calc.containsElement(inArray, elementToCheck);

        //Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> arrayAndBooleanProvider(){
        final int COUNT_OF_TESTS = 10;
        final int COUNT_OF_ELEMENTS_IN_ARRAY = 100;
        if (COUNT_OF_TESTS > COUNT_OF_ELEMENTS_IN_ARRAY * 2)
            throw new RuntimeException("Количество тестов должно быть меньше удвоеного количество элементов в массиве для провеке");

        Arguments[] arguments = new Arguments[COUNT_OF_TESTS];
        int[] inArray = new int[COUNT_OF_ELEMENTS_IN_ARRAY];
        for (int i = 0; i < inArray.length; i++){
            inArray[i] = i * 2;
        }

        for (int i = 0; i < COUNT_OF_TESTS; i++){
            boolean expectedResult;
            if (i % 2 == 0) expectedResult = true;
            else  expectedResult = false;

            arguments[i] = Arguments.of(inArray, i, expectedResult);
        }
        return Arrays.stream(arguments);
    }
}