public class RuleA implements Rule {

    public int price(int quantity) {
        int price = 0;
        price += (quantity / 3) * 130;
        price += (quantity % 3) * 50;
        return price;
    }
}
