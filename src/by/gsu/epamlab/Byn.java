package by.gsu.epamlab;

public class Byn implements Comparable<Byn> {
    private final int kopecks;

    public Byn() {
        this(0);
    }

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(int rubs, int kopecks) {
        this(rubs * 100 + kopecks);
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public int getKopecks() {
        return kopecks;
    }

    public Byn add(Byn byn) {
        return new Byn(kopecks + byn.kopecks);
    }

    public Byn multiply(int secondFactor) {
        return new Byn(kopecks * secondFactor);
    }

    public Byn multiply(double secondFactor, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks * secondFactor, d));
    }

    public Byn subtraction(Byn byn) {
        return new Byn(kopecks-byn.kopecks);
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks, d));
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
