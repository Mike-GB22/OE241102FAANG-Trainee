package task07junit;

import java.util.Arrays;
import java.util.List;

public class NumericOperations {

    // 1. Метод сортировки массива
    public int[] sortArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    // 2. Метод для сложения двух чисел
    public int add(int a, int b) {
        return a + b;
    }

    // 3. Метод поиска числа в массиве
    public boolean containsElement(int[] array, int target) {
        for (int element : array) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    // 4. Метод конвертации строки в число
    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    // 5. Метод для деления чисел, который генерирует исключение при делении на ноль
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}