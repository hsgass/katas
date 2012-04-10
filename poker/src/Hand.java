import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cards = new ArrayList<Card>(5);
    private List<Integer> cardCount = new ArrayList<Integer>(15);
    private long score;


    public Hand(String... cardStrings) {
        // initialize all to 0
        for (int i = 0; i < 15; i++) cardCount.add(0);

        parseHand(cardStrings);
        calculateScore();
    }


    private void parseHand(String[] cardStrings) {
        for (String c : cardStrings) {
            Card card = new Card(c);
            cards.add(card);
            incrementCardCount(card);
        }

        Collections.sort(cards);
    }


    // indices in cardCount correspond to card values.
    // values in cardCount indicate the number of cards with that value.
    private void incrementCardCount(Card card) {
        int value = card.getValue();
        cardCount.set(value, cardCount.get(value) + 1);
    }


    private void calculateScore() {
        if (isStraightFlush()) score += 1l << 60;
        else if (isFourOfAKind()) score += 1l << 59;
        else if (isFullHouse()) score += 1l << 58;
        else if (isFlush()) score += 1l << 57;
        else if (isStraight()) score += 1l << 56;
        else if (isThreeOfAKind()) score += 1l << 55;
        else if (isTwoPair()) score += 1l << 54;
        else if (isPair()) score += 1l << 53;
        else calculateSingleCards();
    }


    private void calculateSingleCards() {
        for (int i = 0; i < 15; i++) {
            if (cardCount.get(i) == 1) score += 1 << i;
        }
    }


    private void calculateAllCards() {
        for (int i = 0; i < 15; i++) {
            if (cardCount.get(i) > 0) score += 1 << i;
        }
    }


    private boolean isPair() {
        int index = cardCount.indexOf(2);
        if (index > -1) {
            score += 1 << (index + 15);
            calculateSingleCards();
            return true;
        }

        return false;
    }


    private boolean isTwoPair() {
        int firstIndex = cardCount.indexOf(2);
        int lastIndex = cardCount.lastIndexOf(2);

        if (firstIndex != -1 && lastIndex != -1 && lastIndex != firstIndex) {
            score += 1 << (firstIndex + 15);
            score += 1 << (lastIndex + 15);
            calculateSingleCards();
            return true;
        }

        return false;
    }


    private boolean isThreeOfAKind() {
        int index = cardCount.indexOf(3);
        if (index > -1) {
            score += 1 << (index + 15);
            calculateSingleCards();
            return true;
        }

        return false;
    }


    private boolean isStraight() {
        checkStraightLowAce();

        if (cards.get(0).getValue() + 1 == cards.get(1).getValue() &&
            cards.get(1).getValue() + 1 == cards.get(2).getValue() &&
            cards.get(2).getValue() + 1 == cards.get(3).getValue() &&
            cards.get(3).getValue() + 1 == cards.get(4).getValue()) {

            calculateAllCards();
            return true;
        }

        return false;
    }


    private void checkStraightLowAce() {
        if (cards.get(4).getValue() == 14 &&
            cards.get(0).getValue() == 2 &&
            cards.get(1).getValue() == 3 &&
            cards.get(2).getValue() == 4 &&
            cards.get(3).getValue() == 5) {

            // pull the ace off the end and stick it in front
            Card ace = cards.remove(4);
            cards.add(0, new Card("L" + ace.getSuit()));

            // reset counts manually
            cardCount.set(1, 1);
            cardCount.set(14, 0);
        }
    }


    private boolean isFlush() {
        if (cards.get(1).matchesSuit(cards.get(0)) &&
            cards.get(2).matchesSuit(cards.get(0)) &&
            cards.get(3).matchesSuit(cards.get(0)) &&
            cards.get(4).matchesSuit(cards.get(0))) {

            calculateAllCards();
            return true;
        }

        return false;
    }


    private boolean isStraightFlush() {
        return cards.get(1).matchesSuit(cards.get(0)) &&
               cards.get(2).matchesSuit(cards.get(0)) &&
               cards.get(3).matchesSuit(cards.get(0)) &&
               cards.get(4).matchesSuit(cards.get(0)) &&
               isStraight();
    }


    private boolean isFullHouse() {
        int indexOf2 = cardCount.indexOf(2);
        int indexOf3 = cardCount.indexOf(3);

        if (indexOf2 > -1 && indexOf3 > -1) {
            score += 1 << (indexOf2 + 15);
            score += 1 << (indexOf3 + 15);
            return true;
        }

        return false;
    }


    private boolean isFourOfAKind() {
        int index = cardCount.indexOf(4);
        if (index > -1) {
            score += 1 << (index + 15);
            calculateSingleCards();
            return true;
        }

        return false;
    }


    public int compareTo(Hand that) {
        long diff = score - that.score;
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 0;
    }
}
