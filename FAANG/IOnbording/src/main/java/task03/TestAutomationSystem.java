//2024.11.03
//Интерфейсы в системе автоматизации тестирования
package task03;

import task03.test.LoginTest;
import task03.test.PaymentTest;
import task03.test.ProductSearchTest;
import task03.test.TestScenario;

import java.util.ArrayList;
import java.util.List;

public class TestAutomationSystem {
    public static void main(String[] args) {
        List<TestScenario> tests = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            tests.add(new LoginTest());
        }

        for(int i = 0; i < 5; i++){
            tests.add(new PaymentTest());
        }

        for(int i = 0; i < 5; i++){
            tests.add(new ProductSearchTest());
        }

        for (TestScenario test : tests){
            test.runTest();
        }
    }
}
