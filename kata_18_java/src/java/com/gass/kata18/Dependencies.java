package com.gass.kata18;

import java.util.HashMap;
import java.util.Map;

public class Dependencies {

    private Map<String, Thing> thingMap = new HashMap<String, Thing>();


    public void add(String valueSet) {
        Thing.get(valueSet, thingMap);
    }


    public Thing get(String thingName) {
        return thingMap.get(thingName);
    }
}
