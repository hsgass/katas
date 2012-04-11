public class RuleB implements Rule {

    public int price(int quantity) {
        int price = 0;
        price += (quantity / 2) * 45;
        price += (quantity % 2) * 30;
        return price;
    }
}
