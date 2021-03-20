package by.gsu.epamlab;

public abstract class Convert {
    public static String convert(int kopecks) {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }
}