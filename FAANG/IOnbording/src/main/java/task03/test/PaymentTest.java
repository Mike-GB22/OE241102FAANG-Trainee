package task03.test;

import java.util.Random;

public class PaymentTest extends AbstractTest{

    @Override
    FlagEntry doLogicTest(){
        if(new Random().nextInt(10) % 2 == 1)
            return new FlagEntry(false, "Payment failed");
        return new FlagEntry(true, "All is ok");
    }
}
