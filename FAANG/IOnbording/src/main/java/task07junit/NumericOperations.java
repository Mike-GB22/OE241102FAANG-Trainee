package task07junit;

import java.util.Arrays;
import java.util.List;

public class NumericOperations {

    // 1. ����� ���������� �������
    public int[] sortArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    // 2. ����� ��� �������� ���� �����
    public int add(int a, int b) {
        return a + b;
    }

    // 3. ����� ������ ����� � �������
    public boolean containsElement(int[] array, int target) {
        for (int element : array) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    // 4. ����� ����������� ������ � �����
    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    // 5. ����� ��� ������� �����, ������� ���������� ���������� ��� ������� �� ����
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}