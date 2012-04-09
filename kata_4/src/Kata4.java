import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * http://codekata.pragprog.com/2007/01/kata_four_data_.html
 */
public class Kata4 {

    public static void main(String[] args) {
        String fileName = args[0];
        String className = args[1];
        Scanner s = null;
        Record min = null;

        try {
            @SuppressWarnings("unchecked")
            Class<Record> clazz = (Class<Record>) Class.forName(className);
            Constructor constructor = clazz.getConstructor(String.class);

            s = new Scanner(new File(fileName));
            while (s.hasNextLine()) {
                Record r = (Record) constructor.newInstance(s.nextLine());
                if (r.matches()) {
                    if (min == null) min = r;
                    else if (r.spread() < min.spread()) min = r;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (s != null) s.close();
        }

        System.out.println(min == null ? "doh" : min.toString());
    }
}
