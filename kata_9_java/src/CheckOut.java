import java.util.HashMap;
import java.util.Map;

/**
 * http://codekata.pragprog.com/2007/01/kata_nine_back_.html
 */
public class CheckOut {

    private Map<String, Rule> ruleMap;
    private Map<String, Integer> itemMap;


    public CheckOut(Map<String, Rule> ruleMap) {
        this.ruleMap = ruleMap;
        itemMap = new HashMap<String, Integer>(ruleMap.size());

        for (String item : ruleMap.keySet()) {
            itemMap.put(item, 0);
        }
    }


    public void scan(String item) {
        if (itemMap.containsKey(item)) {
            itemMap.put(item, itemMap.get(item) + 1);
        }
    }


    public int total() {
        int total = 0;

        for (Map.Entry<String, Integer> items : itemMap.entrySet()) {
            Rule rule = ruleMap.get(items.getKey());
            total += rule.price(items.getValue());
        }

        return total;
    }
}
