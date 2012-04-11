import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class DependenciesTest {

    private Dependencies dependencies;


    @Before
    public void init() {
        dependencies = new Dependencies();
        dependencies.add("A", "B", "C");
        dependencies.add("B", "C", "E");
        dependencies.add("C", "G");
        dependencies.add("D", "A", "F");
        dependencies.add("E", "F");
        dependencies.add("F", "H");
    }


    @Test
    public void A_should_depend_on_BCEFGH() {
        Assert.assertEquals("BCEFGH", dependencies.getFor("A"));
    }


    @Test
    public void B_should_depend_on_CEFGH() {
        Assert.assertEquals("CEFGH", dependencies.getFor("B"));
    }


    @Test
    public void C_should_depend_on_G() {
        Assert.assertEquals("G", dependencies.getFor("C"));
    }


    @Test
    public void D_should_depend_on_ABCEFGH() {
        Assert.assertEquals("ABCEFGH", dependencies.getFor("D"));
    }


    @Test
    public void E_should_depend_on_FH() {
        Assert.assertEquals("FH", dependencies.getFor("E"));
    }


    @Test
    public void F_should_depend_on_H() {
        Assert.assertEquals("H", dependencies.getFor("F"));
    }
}
