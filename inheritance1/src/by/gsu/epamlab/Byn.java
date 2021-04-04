package by.gsu.epamlab;

import java.util.Objects;

public class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn copyKopecks) {
        this(copyKopecks.kopecks);
    }

    public Byn multiply(int secondFactor) {
        kopecks *= secondFactor;
        return this;
    }

    public Byn multiply(double secondFactor) {
        kopecks = (int) Math.round((kopecks * secondFactor));
        return this;
    }

    public Byn subtraction(Byn minuend) {
        kopecks -= minuend.kopecks;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return kopecks == byn.kopecks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kopecks);
    }

    @Override
    public int compareTo(Byn o) {
        return kopecks - o.kopecks;
    }
}
