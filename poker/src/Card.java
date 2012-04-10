import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    private static final Map<String, Integer> values = new HashMap<String, Integer>();


    static {
        // low ace (for straights)
        values.put("L", 1);
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        values.put("T", 10);
        values.put("J", 11);
        values.put("Q", 12);
        values.put("K", 13);
        values.put("A", 14);
    }


    private String suit;
    private String valueName;
    private int value;


    public Card(String cardString) {
        cardString = cardString.toUpperCase();
        valueName = String.valueOf(cardString.charAt(0));
        value = values.get(valueName);
        suit = String.valueOf(cardString.charAt(1));

        if(cardString.startsWith("L")) {
            valueName = "A";
        }
    }


    public int getValue() {
        return value;
    }


    public String getSuit() {
        return suit;
    }


    public boolean matchesSuit(Card that) {
        return suit.equals(that.suit);
    }


    public int compareTo(Card card) {
        return value - card.value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return value == card.value;
    }


    @Override
    public int hashCode() {
        return value;
    }


    @Override
    public String toString() {
        return valueName + suit;
    }
}
