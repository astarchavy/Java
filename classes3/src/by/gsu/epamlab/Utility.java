package by.gsu.epamlab;

public class Utility {
    private Utility() {
    }

    public static String convert(int kopecks) {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }
}