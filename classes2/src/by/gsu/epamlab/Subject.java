package by.gsu.epamlab;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public Subject() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + ";" + this.material + ";" + this.volume + ";" + this.getMass();
    }

    public double getMass() {
        return this.material.getDensity() * this.volume;
    }
}