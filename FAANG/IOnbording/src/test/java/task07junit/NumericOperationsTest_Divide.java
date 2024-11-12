package task07junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumericOperationsTest_Divide {

    NumericOperations calc;

    @BeforeEach
    void setUp(){
        calc = new NumericOperations();
    }

    @Test
    @DisplayName("Positive. Простая проверка")
    void dividePositiveEinFach() {
        //Arrange
        int a = 10;
        int b = 2;
        int expectedDividend = 5;

        //Act
        int result = calc.divide(a, b);

        //Assert
        assertEquals(expectedDividend, result);
    }

    @ParameterizedTest
    @DisplayName("Positive. Параметризированная проверка")
    @MethodSource("numbersProvider")
    void dividePositiveParams(int a, int b, int expectedDividend){
        //Act
        int result = calc.divide(a, b);

        //Assert
        assertEquals(expectedDividend, result);
    }
    
    @Test
    @DisplayName("Negative. Простой тест, деления на ноль")
    void divideNegativeEinfach(){
        //Arrange
        int a = 100;
        int b = 0;

        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> calc.divide(a ,b));
    }

    @ParameterizedTest
    @DisplayName("Negative. Параметризированный, деления на ноль")
    @MethodSource("numbersProviderWithZeroAsSecondArgument")
    void divideNegativeEinfach(int a, int b){
        //Arrange
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> calc.divide(a ,b));
    }

    static Stream<Arguments> numbersProviderWithZeroAsSecondArgument(){
        return numbersProvider().map(x -> Arguments.of(x.get()[0], 0)).distinct();
    }

    static Stream<Arguments> numbersProvider(){
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(10, 1, 10),
                Arguments.of(-1, 1, -1),
                Arguments.of(0, -1, 0),
                Arguments.of(5, 5, 1),
                Arguments.of(4, 3, 1),
                Arguments.of(3, 2, 1),
                Arguments.of(2, 3, 0),
                Arguments.of(100, 200, 0),
                Arguments.of(1_100_000_000, 1_000_000_000, 1),
                Arguments.of(-1_100_000_000, 1_000_000_000, -1),
                Arguments.of(1_000_000_000, -1_100_000_000, 0),
                Arguments.of(Integer.MAX_VALUE, -1 * Integer.MAX_VALUE, -1),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 0),
                Arguments.of( Integer.MIN_VALUE, Integer.MAX_VALUE, -1));
    }
}