package task03.test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;

public class LoginTest implements TestScenario{
    @Override
    public boolean runTest() {
        FlagEntry flag = doLogicTest();
        System.out.println("LoginTest is " + (flag.getKey() ? "OK" : "Bad! Reason: " + flag.getValue()));
        return flag.getKey();
    }

    private FlagEntry doLogicTest(){
        if(new Random().nextInt(10) % 2 == 1)
            return new FlagEntry(false, "Login is incorrect");
        return new FlagEntry(true, "All is ok");
    }
}
