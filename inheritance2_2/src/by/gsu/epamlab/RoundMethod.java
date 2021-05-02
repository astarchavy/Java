package by.gsu.epamlab;

public enum RoundMethod {
    FLOOR {
        @Override
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND {
        @Override
        double roundFunction(double d) {
            return Math.round(d);
        }
    },
    CEIL {
        @Override
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    };

    abstract double roundFunction(double value);

    public int round(double roundedValue, int d) {
        int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int tenPow = tenPowD[d];
        return (int) roundFunction(roundedValue / tenPow) * tenPow;
    }
}