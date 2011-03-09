package com.gass.kata18;

import org.jruby.RubyArray;

import java.util.HashMap;
import java.util.Map;

public class Dependencies {

    private Map things = new HashMap();

    public void add(RubyArray table) {
        for(int i = 0; i < table.getLength(); i++) {
            RubyArray row = (RubyArray) table.get(i);
            String s = (String) row.get(0);
            String name = s.substring(0, 1);
            String values = s.substring(1);
            things.put(name, values);
        }
    }
    public Object get(String thingName) {
        return things.get(thingName);
    }
}
