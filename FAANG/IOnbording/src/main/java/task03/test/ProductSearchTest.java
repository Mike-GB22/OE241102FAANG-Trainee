package task03.test;

import java.util.Random;

public class ProductSearchTest extends AbstractTest{

    @Override
    FlagEntry doLogicTest(){
        if(new Random().nextInt(10) % 2 == 1)
            return new FlagEntry(false, "Search error");
        return new FlagEntry(true, "All is ok");
    }

}
