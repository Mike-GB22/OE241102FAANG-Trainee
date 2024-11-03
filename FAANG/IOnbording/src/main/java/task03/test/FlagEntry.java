package task03.test;

import java.util.AbstractMap;

public class FlagEntry extends AbstractMap.SimpleEntry<Boolean, String>{
    public FlagEntry(Boolean flag, String message){
        super(flag, message);
    }
}
