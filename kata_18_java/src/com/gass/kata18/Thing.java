package com.gass.kata18;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Thing implements Comparable<Thing> {

    private String name;
    private Set<Thing> myDependencies = new LinkedHashSet<Thing>();


    private Thing(String dependencySet, Map<String, Thing> thingMap) {
        name = Thing.findName(dependencySet);
        String values = Thing.findValues(dependencySet);
        Thing currentThing = null;
        for (char c : values.toCharArray()) {
            Thing newThing = Thing.get(String.valueOf(c), thingMap);
            myDependencies.add(newThing);
            if (currentThing != null) currentThing.myDependencies.add(newThing);
            currentThing = newThing;
        }
        thingMap.put(name, this);
    }


    public static Thing get(String dependencySet, Map<String, Thing> thingMap) {
        Thing t = thingMap.get(findName(dependencySet));
        if (t == null) {
            t = new Thing(dependencySet, thingMap);
        } 
        return t;
    }


    public static String findName(String dependencySet) {
        return dependencySet.substring(0, 1);
    }


    public static String findValues(String dependencySet) {
        return dependencySet.substring(1);
    }


    public String getName() {
        return name;
    }


    public String getDependencies() {
        String deps = "";
        Set<Thing> depSet = new LinkedHashSet<Thing>();
        for (Thing thing : myDependencies) {
            depSet.add(thing);
            depSet.addAll(thing.myDependencies);
        }
        for (Thing thing : depSet) {
            deps += thing.getName();
        }
        return deps;
    }


    public int compareTo(Thing that) {
        return that == null ? 1 : name.compareTo(that.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thing thing = (Thing) o;

        if (name != null ? !name.equals(thing.name) : thing.name != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
