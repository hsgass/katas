import junit.framework.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void ace_should_be_greater_than_king() {
        Card ace = new Card("ah");
        Card two = new Card("kh");
        Assert.assertTrue(ace.compareTo(two) > 0);
    }


    @Test
    public void ten_should_be_greater_than_9() {
        Card ten = new Card("TH");
        Card nine = new Card("9C");
        Assert.assertTrue(ten.compareTo(nine) > 0);
    }
}
