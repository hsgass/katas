import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherRecord implements Record {
    private static final Pattern PATTERN = Pattern.compile("^\\s+(\\d+)\\D+(\\d+)\\D+(\\d+).*");

    private int day;
    private int max;
    private int min;

    public WeatherRecord(String line) {
        Matcher r = PATTERN.matcher(line);
        if (r.matches()) {
            day = Integer.parseInt(r.group(1));
            max = Integer.parseInt(r.group(2));
            min = Integer.parseInt(r.group(3));
        }
    }

    public int spread() {
        return max - min;
    }

    public boolean matches() {
        return day > 0;
    }

    @Override
    public String toString() {
        return "" + day + " " + max + " " + min;
    }
}
