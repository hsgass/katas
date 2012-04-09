import java.util.ArrayList;
import java.util.List;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 */
public class Chop {
    public static int search(int i, int[] array) {
        if (array.length > 0) {
            return search(i, getList(array));
        }

        return -1;
    }

    public static int search(int i, List<Integer> list) {
        if (list.get(0) == i) return 0;

        int index = -1;

        if (list.size() > 1) {
            int halfIndex = list.size() / 2;

            if (list.get(halfIndex) > i) {
                index = search(i, list.subList(0, halfIndex));
            }

            else if (list.size() > halfIndex) {
                int search = search(i, list.subList(halfIndex, list.size()));
                index = search > -1 ? halfIndex + search : -1;
            }
        }

        return index;
    }

    private static List<Integer> getList(int[] array) {
        List<Integer> list = new ArrayList<Integer>(array.length);
        for (int i : array) {
            list.add(i);
        }

        return list;
    }
}
