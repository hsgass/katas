import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ThingTest {

    private Map<String, Thing> thingMap;

    @Before
    public void init() {
        thingMap = new HashMap<String, Thing>();
    }

    @Test
    public void should_initialize_with_correct_name() {
        Thing t = Thing.get("AB", thingMap);
        assertEquals("A", t.getName());
    }

    @Test
    public void should_be_in_thingMap_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        assertTrue(thingMap.containsValue(t));
    }

    @Test
    public void dependency_should_be_in_thingMap_after_initialization() {
        Thing.get("AB", thingMap);
        assertNotNull(thingMap.get("B"));
    }

    @Test
    public void should_report_single_dependency() {
        Thing t = Thing.get("AB", thingMap);
        assertEquals("B", t.getDependencyString());
    }

    @Test
    public void should_report_five_dependencies() {
        Thing t = Thing.get("ABCDEF", thingMap);
        assertEquals("BCDEF", t.getDependencyString());
    }

    @Test
    public void should_not_report_duplicate_dependencies() {
        Thing t = Thing.get("ABBBB", thingMap);
        assertEquals("B", t.getDependencyString());
    }

    @Test
    public void should_initialize_with_single_char() {
        try {
            Thing.get("A", thingMap);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void should_report_dependencies_added_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        Thing.get("BC", thingMap);
        assertEquals("BC", t.getDependencyString());
    }

    @Test
    public void should_report_dependencies_added_to_dependencies_added_after_initialization() {
        Thing t = Thing.get("AB", thingMap);
        Thing.get("BC", thingMap);
        Thing.get("CDEF", thingMap);
        assertEquals("BCDEF", t.getDependencyString());
    }

    @Test
    public void should_report_dependencies_previously_added_to_dependencies() {
        Thing.get("ABC", thingMap);
        Thing t = Thing.get("DA", thingMap);
        assertEquals("ABC", t.getDependencyString());
    }
}
