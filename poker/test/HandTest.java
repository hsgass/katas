import junit.framework.Assert;
import org.junit.Test;

public class HandTest {

    @Test
    public void ace_should_beat_king() {
        Hand ace = new Hand("2h", "3c", "4h", "6h", "ah");
        Hand king = new Hand("8h", "td", "js", "qc", "kh");
        Assert.assertTrue(ace.compareTo(king) > 0);
    }


    @Test
    public void pair_should_beat_high_card() {
        Hand pair = new Hand("2h", "2c", "3h", "4h", "5h");
        Hand highCard = new Hand("8h", "td", "js", "qc", "ah");
        Assert.assertTrue(pair.compareTo(highCard) > 0);
    }


    @Test
    public void two_eights_should_beat_two_sevens() {
        Hand eights = new Hand("8h", "8c", "2h", "3h", "4h");
        Hand sevens = new Hand("7h", "7d", "qs", "kc", "ah");
        Assert.assertTrue(eights.compareTo(sevens) > 0);
    }


    @Test
    public void same_pair_should_score_by_high_card() {
        Hand eights = new Hand("8h", "8c", "2h", "3h", "kh");
        Hand eights2 = new Hand("8h", "8d", "ts", "jc", "qh");
        Assert.assertTrue(eights.compareTo(eights2) > 0);
    }


    @Test
    public void two_pair_should_beat_pair() {
        Hand twoPair = new Hand("3h", "3c", "5h", "5h", "7h");
        Hand pair = new Hand("3h", "3d", "7s", "9c", "jh");
        Assert.assertTrue(twoPair.compareTo(pair) > 0);
    }


    @Test
    public void higher_of_two_pair_should_win() {
        Hand twoPair = new Hand("kh", "kc", "th", "th", "7h");
        Hand twoPair2 = new Hand("qh", "qd", "ts", "tc", "7h");
        Assert.assertTrue(twoPair.compareTo(twoPair2) > 0);
    }


    @Test
    public void lower_value_of_two_pair_should_win_if_higher_pairs_are_equal() {
        Hand twoPair = new Hand("kh", "kc", "qh", "qh", "7h");
        Hand twoPair2 = new Hand("kh", "kd", "js", "jc", "7h");
        Assert.assertTrue(twoPair.compareTo(twoPair2) > 0);
    }


    @Test
    public void same_two_pair_should_score_by_high_card() {
        Hand twoPair = new Hand("kh", "kc", "qh", "qh", "7h");
        Hand twoPair2 = new Hand("kh", "kd", "qs", "qc", "6h");
        Assert.assertTrue(twoPair.compareTo(twoPair2) > 0);
    }


    @Test
    public void threeOfAKind_should_beat_two_pair() {
        Hand threeOfAKind = new Hand("3h", "3d", "3s", "9c", "jh");
        Hand twoPair = new Hand("3h", "3c", "5h", "5h", "7h");
        Assert.assertTrue(threeOfAKind.compareTo(twoPair) > 0);
    }


    @Test
    public void higher_of_threeOfAKind_should_win() {
        Hand threeOfAKind = new Hand("kh", "kc", "kh", "5h", "7h");
        Hand threeOfAKind2 = new Hand("qh", "qd", "qs", "5c", "7h");
        Assert.assertTrue(threeOfAKind.compareTo(threeOfAKind2) > 0);
    }


    @Test
    public void same_threeOfAKind_should_score_by_high_card() {
        Hand threeOfAKind = new Hand("kh", "kc", "kh", "5h", "3h");
        Hand threeOfAKind2 = new Hand("kh", "kd", "ks", "5c", "2h");
        Assert.assertTrue(threeOfAKind.compareTo(threeOfAKind2) > 0);
    }


    @Test
    public void straight_should_beat_threeOfAKind() {
        Hand straight = new Hand("2h", "3h", "4c", "5s", "6d");
        Hand threeOfAKind = new Hand("ah", "ad", "as", "kc", "qh");
        Assert.assertTrue(straight.compareTo(threeOfAKind) > 0);
    }


    @Test
    public void straight_can_have_low_ace() {
        Hand straight = new Hand("ah", "2h", "3c", "4s", "5d");
        Hand threeOfAKind = new Hand("ah", "ad", "as", "kc", "qh");
        Assert.assertTrue(straight.compareTo(threeOfAKind) > 0);
    }


    @Test
    public void flush_should_beat_straight() {
        Hand flush = new Hand("3h", "3h", "3h", "9h", "jh");
        Hand straight = new Hand("th", "jh", "qc", "ks", "ad");
        Assert.assertTrue(flush.compareTo(straight) > 0);
    }


    @Test
    public void full_house_should_beat_flush() {
        Hand fullHouse = new Hand("3h", "3h", "3c", "4s", "4d");
        Hand flush = new Hand("3h", "3h", "3h", "9h", "jh");
        Assert.assertTrue(fullHouse.compareTo(flush) > 0);
    }


    @Test
    public void fourOfAKind_should_beat_fullHouse() {
        Hand fourOfAKind = new Hand("3h", "3h", "3h", "3h", "jh");
        Hand fullHouse = new Hand("3h", "3h", "3c", "4s", "4d");
        Assert.assertTrue(fourOfAKind.compareTo(fullHouse) > 0);
    }


    @Test
    public void higher_of_fourOfAKind_should_win() {
        Hand fourOfAKind = new Hand("3h", "3h", "3h", "3h", "2h");
        Hand fourOfAKind2 = new Hand("2h", "2h", "2c", "2s", "ad");
        Assert.assertTrue(fourOfAKind.compareTo(fourOfAKind2) > 0);
    }


    @Test
    public void same_fourOfAKind_should_score_by_high_card() {
        Hand fourOfAKind = new Hand("kh", "kc", "kh", "kh", "3h");
        Hand fourOfAKind2 = new Hand("kh", "kd", "ks", "kc", "2h");
        Assert.assertTrue(fourOfAKind.compareTo(fourOfAKind2) > 0);
    }


    @Test
    public void straight_flush_should_beat_fourOfAKind() {
        Hand straightFlush = new Hand("3h", "4h", "5h", "6h", "7h");
        Hand fourOfAKind = new Hand("ah", "ad", "as", "ac", "kh");
        Assert.assertTrue(straightFlush.compareTo(fourOfAKind) > 0);
    }


    @Test
    public void straight_flush_should_check_high_card() {
        Hand straightFlush = new Hand("th", "jh", "qh", "kh", "ah");
        Hand highCard = new Hand("9H", "th", "jh", "qh", "kh");
        Assert.assertTrue(straightFlush.compareTo(highCard) > 0);
    }
}
