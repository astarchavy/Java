package by.gsu.epamlab;

import java.util.Objects;

public final class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn() {
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

    public Byn add(Byn byn) {
        kopecks += byn.kopecks;
        return this;
    }

    public Byn multiply(int secondFactor) {
        kopecks *= secondFactor;
        return this;
    }

    public Byn multiply(double secondFactor, RoundMethod roundMethod, int d) {
        kopecks = RoundMethod.ROUND.round(kopecks * secondFactor, roundMethod, d);
        return this;
    }

    public Byn subtraction(Byn byn) {
        kopecks -= byn.kopecks;
        return this;
    }

    public Byn round(RoundMethod roundMethod, int d) {
        kopecks = RoundMethod.ROUND.round(kopecks, roundMethod, d);
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

    public enum RoundMethod {
        FLOOR {
            double roundFunction(double d) {
                return Math.floor(d);
            }
        },

        CEIL {
            double roundFunction(double d) {
                return Math.ceil(d);
            }
        },

        ROUND {
            double roundFunction(double d) {
                return Math.round(d);
            }
        };

        abstract double roundFunction(double value);

        public int round(double roundedValue, RoundMethod roundMethod, int d) {
            int tenPow = pow10(d);
            int result = (int) roundMethod.roundFunction(roundedValue / tenPow) * tenPow;
            return result;
        }

        int pow10(int d) {
            int[] tenPowD = {1, 10, 100, 100, 1000, 10000, 1000000, 10000000, 100000000};
            return tenPowD[d];
        }
    }
}
