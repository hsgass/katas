import junit.framework.Assert;
import org.junit.Test;

public class ThingTest {

    @Test
    public void should_add_dependency() {
        Thing a = new Thing("A");
        Thing b = new Thing("B");
        a.addDependency(b);
        Assert.assertEquals("B", a.getDependencyString());
    }


    @Test
    public void should_add_two_dependencies() {
        Thing a = new Thing("A");
        Thing b = new Thing("B");
        Thing c = new Thing("C");

        a.addDependency(b);
        a.addDependency(c);

        Assert.assertEquals("BC", a.getDependencyString());
    }
}
