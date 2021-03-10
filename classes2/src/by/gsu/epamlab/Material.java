package by.gsu.epamlab;

public class Material {
    private final String name;
    private final double density;

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public Material() {
        this(null, 0.0);
    }

    public String getName() {
        return this.name;
    }

    public double getDensity() {
        return this.density;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.density;
    }
}
