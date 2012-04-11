import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckOutTest {

    private static final Map<String, Rule> RULES = new HashMap<String, Rule>();


    static {
        RULES.put("A", new RuleA());
        RULES.put("B", new RuleB());
        RULES.put("C", new RuleC());
        RULES.put("D", new RuleD());
    }


    private int price(String goods) {
        CheckOut checkOut = new CheckOut(RULES);
        String[] split = goods.split("");
        for (String s : split) {
            checkOut.scan(s);
        }

        return checkOut.total();
    }


    @Test
    public void nothing_should_equal_0() {
        Assert.assertEquals(0, price(""));
    }


    @Test
    public void A_should_equal_50() {
        Assert.assertEquals(50, price("A"));
    }


    @Test
    public void AB_should_equal_80() {
        Assert.assertEquals(80, price("AB"));
    }


    @Test
    public void CDBA_should_equal_115() {
        Assert.assertEquals(115, price("CDBA"));
    }


    @Test
    public void AA_should_equal_100() {
        Assert.assertEquals(100, price("AA"));
    }


    @Test
    public void AAA_should_equal_130() {
        Assert.assertEquals(130, price("AAA"));
    }


    @Test
    public void AAAA_should_equal_180() {
        Assert.assertEquals(180, price("AAAA"));
    }


    @Test
    public void AAAAA_should_equal_230() {
        Assert.assertEquals(230, price("AAAAA"));
    }


    @Test
    public void AAAAAA_should_equal_260() {
        Assert.assertEquals(260, price("AAAAAA"));
    }


    @Test
    public void AAAB_should_equal_160() {
        Assert.assertEquals(160, price("AAAB"));
    }


    @Test
    public void AAABB_should_equal_175() {
        Assert.assertEquals(175, price("AAABB"));
    }


    @Test
    public void AAABBD_should_equal_190() {
        Assert.assertEquals(190, price("AAABBD"));
    }


    @Test
    public void DABABA_should_equal_190() {
        Assert.assertEquals(190, price("DABABA"));
    }


    @Test
    public void DABABABAC_should_equal_290() {
        Assert.assertEquals(290, price("DABABABAC"));
    }
}
