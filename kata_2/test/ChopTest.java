import junit.framework.Assert;
import org.junit.Test;

public class ChopTest {

    @Test
    public void test3from0() {
        Assert.assertTrue(-1 == Chop.search(3, new int[]{0}));
    }

    @Test
    public void test3from1() {
        Assert.assertTrue(0 == Chop.search(1, new int[]{1}));
    }

    @Test
    public void test1from135() {
        Assert.assertTrue(0 == Chop.search(1, new int[]{1, 3, 5}));
    }

    @Test
    public void test3from135() {
        Assert.assertTrue(1 == Chop.search(3, new int[]{1, 3, 5}));
    }

    @Test
    public void test5from135() {
        Assert.assertTrue(2 == Chop.search(5, new int[]{1, 3, 5}));
    }

    @Test
    public void test0from135() {
        Assert.assertTrue(-1 == Chop.search(0, new int[]{1, 3, 5}));
    }

    @Test
    public void test2from135() {
        Assert.assertTrue(-1 == Chop.search(2, new int[]{1, 3, 5}));
    }

    @Test
    public void test4from135() {
        Assert.assertTrue(String.valueOf(Chop.search(4, new int[]{1, 3, 5})),
                          -1 == Chop.search(4, new int[]{1, 3, 5}));
    }

    @Test
    public void test6from135() {
        Assert.assertTrue(-1 == Chop.search(6, new int[]{1, 3, 5}));
    }

    @Test
    public void test1from1357() {
        Assert.assertTrue(0 == Chop.search(1, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test3from1357() {
        Assert.assertTrue(1 == Chop.search(3, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test5from1357() {
        Assert.assertTrue(2 == Chop.search(5, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test7from1357() {
        Assert.assertTrue(3 == Chop.search(7, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test0from1357() {
        Assert.assertTrue(-1 == Chop.search(0, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test2from1357() {
        Assert.assertTrue(-1 == Chop.search(2, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test4from1357() {
        Assert.assertTrue(-1 == Chop.search(4, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test6from1357() {
        Assert.assertTrue(-1 == Chop.search(6, new int[]{1, 3, 5, 7}));
    }

    @Test
    public void test8from1357() {
        Assert.assertTrue(-1 == Chop.search(8, new int[]{1, 3, 5, 7}));
    }

}
