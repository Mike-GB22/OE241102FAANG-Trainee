//2024.11.12
//Тесты для метода, выполняющего сложение. Проверьте различные комбинации значений и граничные случаи.
package task07junit;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumericOperationsTest_Add {

    NumericOperations calc;

    @BeforeEach
    void setUp(){
        calc = new NumericOperations();
    }

    @Test
    @DisplayName("Positive. Простая проверка")
    void addPositiveEinFach() {
        //Arrange
        int a = 1;
        int b = 2;
        int expectedSum = 3;

        //Act
        int result = calc.add(a, b);

        //Assert
        assertEquals(expectedSum, result);
    }

    @ParameterizedTest
    @DisplayName("Positive. Параметризированная проверка")
    @MethodSource("numbersProvider")
    void addPositiveParams(int a, int b, int expectedSum){
        //Act
        int result = calc.add(a, b);

        //Assert
        assertEquals(expectedSum, result);
    }

    static Stream<Arguments> numbersProvider(){
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 0, 1),
                Arguments.of(0, 1, 1),
                Arguments.of(-1, 0, -1),
                Arguments.of(0, -1, -1),
                Arguments.of(1, 0, 1),
                Arguments.of(0, -1, -1),
                Arguments.of(-1, 0, -1),
                Arguments.of(0, 1, 1),
                Arguments.of(100, 200, 300),
                Arguments.of(1_000_000_000, 1_100_000_000, 2_100_000_000),
                Arguments.of(-1_000_000_000, -1_100_000_000, -2_100_000_000),
                Arguments.of(1_000_000_000, -1_100_000_000, -100_000_000),
                Arguments.of(Integer.MAX_VALUE, -1 * Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, -1));
    }
}