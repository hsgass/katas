import java.util.Set;
import java.util.TreeSet;

public class Thing implements Comparable<Thing> {

    private String name;
    private Set<Thing> dependencies = new TreeSet<Thing>();


    public Thing(String name) {
        this.name = name;
    }


    public void addDependency(Thing thing) {
        dependencies.add(thing);
    }


    public String getDependencyString() {
        return getDependencies().toString().replaceAll("\\W", "");
    }


    public Set<Thing> getDependencies() {
        TreeSet<Thing> deps = new TreeSet<Thing>();

        for (Thing dep : dependencies) {
            deps.add(dep);
            deps.addAll(dep.getDependencies());
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

        return !(name != null ? !name.equals(thing.name) : thing.name != null);
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
