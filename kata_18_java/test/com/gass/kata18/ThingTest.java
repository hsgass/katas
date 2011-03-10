package com.gass.kata18;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ThingTest {

    private Map<String, Thing> thingMap;

    @Before
    public void init() {
        thingMap = new HashMap<String, Thing>();
    }

    @Test
    public void should_initialize_with_correct_name() {
        Thing t = Thing.get("AB", thingMap);
        Assert.assertEquals("A", t.getName());
    }

    @Test
    public void should_be_in_thingMap_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        Assert.assertTrue(thingMap.containsValue(t));
    }

    @Test
    public void dependency_should_be_in_thingMap_after_initialization() {
        Thing.get("AB", thingMap);
        Assert.assertNotNull(thingMap.get("B"));
    }

    @Test
    public void should_report_single_dependency() {
        Thing t = Thing.get("AB", thingMap);
        Assert.assertEquals("B", t.getDependencies());
    }

    @Test
    public void should_report_five_dependencies() {
        Thing t = Thing.get("ABCDEF", thingMap);
        Assert.assertEquals("BCDEF", t.getDependencies());
    }

    @Test
    public void should_not_report_duplicate_dependencies() {
        Thing t = Thing.get("ABBBB", thingMap);
        Assert.assertEquals("B", t.getDependencies());
    }

    @Test
    public void should_initialize_with_single_char() {
        try {
            Thing.get("A", thingMap);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void should_report_dependencies_added_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        Thing.get("BC", thingMap);
        Assert.assertEquals("BC", t.getDependencies());
    }

    @Test
    public void should_report_dependencies_added_to_dependencies_added_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        Thing.get("C", thingMap);
        Thing.get("CDEF", thingMap);
        Assert.assertEquals("BCDEF", t.getDependencies());
    }
}
