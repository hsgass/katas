import java.util.HashMap;
import java.util.Map;

/**
 * http://codekata.pragprog.com/2007/01/kata_eighteen_t.html
 */
public class Dependencies {

    private Map<String, Thing> thingMap = new HashMap<String, Thing>();


    public void add(String name, String... dependencies) {
        Thing thing = getThing(name);

        for (String s : dependencies) {
            Thing t = getThing(s);
            thing.addDependency(t);
        }
    }


    public String getFor(String thingName) {
        return getThing(thingName).getDependencyString();
    }


    private Thing getThing(String s) {
        Thing t = thingMap.get(s);
        if (t == null) {
            t = new Thing(s);
            thingMap.put(s, t);
        }
        
        return t;
    }
}
