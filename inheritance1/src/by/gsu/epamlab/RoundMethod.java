package by.gsu.epamlab;

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

    public int round(double roundedValue, int d) {
        int tenPow = pow10(d);
        int result = (int) roundFunction(roundedValue / tenPow) * tenPow;
        return result;
    }

    private static int pow10(int d) {
        int[] tenPowD = {1, 10, 100, 100, 1000, 10000, 1000000, 10000000, 100000000};
        return tenPowD[d];
    }
}
