package task07junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.*;

class NumericOperationsTest_SortArray {

    NumericOperations calc;
    @BeforeEach
    void setUp() {
        calc = new NumericOperations();
    }

    @Test
    @DisplayName("Positive. Простой тест")
    void sortArrayPositiveEinfach() {
        //Arrange
        int[] inArray = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int[] outArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Act
        int[] result = calc.sortArray(inArray);

        //Assert
        assertArrayEquals(outArray, result);
    }

    @ParameterizedTest
    @DisplayName("Positive. Параметризированный тест")
    @MethodSource("arraysProvider")
    void sortArrayPositiveParams(int[] inArray, int[] outArray){
        //Arrange
        //Act
        int[] result = calc.sortArray(inArray);

        //Assert
        assertArrayEquals(outArray, result);
    }

    @Test
    @DisplayName("Positive. Тест с одним элементом")
    void sortArrayPositiveParamTwo(){
        //Arrange
        int[] inArray = {1};

        //Act
        int[] result = calc.sortArray(inArray);

        //Assert
        assertArrayEquals(inArray, result);
    }

    static Stream<Arguments> arraysProvider(){
        final int COUNT_OF_TEST = 10;
        final int COUNT_OF_ELEMENTS_IN_FIRST_TEST = 10;
        Arguments[] arguments = new Arguments[COUNT_OF_TEST];

        for(int i = 0; i < COUNT_OF_TEST; i++){
            final int SIZE_OF_ARRAY_FOR_THIS_TEST = COUNT_OF_ELEMENTS_IN_FIRST_TEST * i;
            int[] arrayForThisTest = new int[SIZE_OF_ARRAY_FOR_THIS_TEST];
            Random rnd = new Random();

            for(int j = 0; j < SIZE_OF_ARRAY_FOR_THIS_TEST; j++){
                arrayForThisTest[j] = rnd.nextInt();
            }

            int[] sortedArrayForThisTest = arrayForThisTest.clone();
            Arrays.sort(sortedArrayForThisTest);
            arguments[i] = Arguments.of(
                    arrayForThisTest
                    , sortedArrayForThisTest);
        }
        return Arrays.stream(arguments);
    }
}