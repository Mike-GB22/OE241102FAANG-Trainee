package task03.test;

import java.util.Random;

public abstract class AbstractTest implements TestScenario{
    private static int count;
    private int id;
    AbstractTest(){
        id = count++;
    }

    @Override
    public boolean runTest() {
        FlagEntry flag = doLogicTest();
        System.out.println(
                "Test id: " + id + ". "
                + this.getClass().getSimpleName()
                + " is "
                + (flag.getKey() ? "OK" : "Bad! Reason: " + flag.getValue()));
        return flag.getKey();
    }

    abstract FlagEntry doLogicTest();
}
