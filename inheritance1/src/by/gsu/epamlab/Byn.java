package by.gsu.epamlab;

import java.util.Objects;

public final class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn() {
    }

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn add(Byn byn) {
        kopecks += byn.kopecks;
        return this;
    }

    public Byn multiply(int secondFactor) {
        kopecks *= secondFactor;
        return this;
    }

    public Byn multiply(double secondFactor) {
        kopecks = (int) Math.round((kopecks * secondFactor));
        return this;
    }

    public Byn subtraction(Byn byn) {
        kopecks -= byn.kopecks;
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
    public int compareTo(Byn o) {
        return kopecks - o.kopecks;
    }
}
