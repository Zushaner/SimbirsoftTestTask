package utils;

public class Utils {
    public static int getRandomInt(int left, int right) {
        return left + (int) (Math.random() * (right-left));
    }

}
