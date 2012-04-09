import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballRecord implements Record {
    private static final Pattern PATTERN = Pattern.compile(".*\\d{1,2}\\. ([a-zA-Z_]+).*\\s(\\d+)  -  (\\d+).*");

    private String name;
    private int f;
    private int a;

    public FootballRecord(String line) {
        Matcher r = PATTERN.matcher(line);
        if (r.matches()) {
            name = r.group(1);
            f = Integer.parseInt(r.group(2));
            a = Integer.parseInt(r.group(3));
        }
    }

    public int spread() {
        return Math.abs(f - a);
    }

    public boolean matches() {
        return f > 0;
    }

    @Override
    public String toString() {
        return name + " " + f + " " + a + " " +  spread();
    }
}
