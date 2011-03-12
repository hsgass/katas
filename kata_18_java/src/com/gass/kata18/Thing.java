package com.gass.kata18;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Thing implements Comparable<Thing> {

    private String name;
    private Set<Thing> parents = new LinkedHashSet<Thing>();
    private Set<Thing> children = new LinkedHashSet<Thing>();


    private Thing(String name) {
        this.name = name;
    }


    public static Thing get(String dependencyString, Map<String, Thing> thingMap) {
        Thing thing = null;
        if (dependencyString != null) {
            String name = findName(dependencyString);
            thing = thingMap.get(name);
            if (thing == null) {
                thing = new Thing(name);
                thingMap.put(name, thing);
            }

            if (dependencyString.length() > 1) {
                for (int i = 1; i < dependencyString.length(); i++) {
                    Thing newThing = Thing.get(dependencyString.substring(i), thingMap);
                    thing.addDependency(newThing, thingMap);
                }
            }
        }
        return thing;
    }


    public String getName() {
        return name;
    }


    public String getDependencies() {
        String deps = "";
        for (Thing dep : children) {
            deps += dep;
        }
        return deps;
    }


    public void addDependency(Thing thing, Map<String, Thing> thingMap) {
        if (thing != null && !children.contains(thing)) {
            children.add(thing);
            thing.addParent(this);
            for (Thing p : parents) {
                p.addDependency(thing, thingMap);
            }
        }
    }

    public void addParent(Thing thing) {
        parents.add(thing);
    }


    private static String findName(String dependencyString) {
        return dependencyString.length() <= 1 ? dependencyString : dependencyString.substring(0, 1);
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

    @Override
    public String toString() {
        return name;
    }
}
