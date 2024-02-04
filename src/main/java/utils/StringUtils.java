package utils;

public class StringUtils {
    public static String dayToStringFormat(int day) {
        return ((day < 10) ? "0" : "") + day;
    }
}
