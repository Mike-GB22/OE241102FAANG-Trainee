package task05;

import java.util.AbstractMap;

public class KeyEntry extends AbstractMap.SimpleEntry<String, Integer>{

    public KeyEntry(String key, Integer value) {
        super(key, value);
    }
}
