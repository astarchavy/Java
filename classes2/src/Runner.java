import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {
    public static void main(String[] args) {
        Material STEEL = new Material("steel", 7850.0);
        Subject wire = new Subject("wire", STEEL, 0.03);
        System.out.println(wire);
        Material COPPER = new Material("copper", 8500.0);
        wire.setMaterial(COPPER);
        System.out.println(wire.getMass());
    }
}