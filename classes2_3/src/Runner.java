import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;
import static by.gsu.epamlab.Material.COPPER;
import static by.gsu.epamlab.Material.STEEL;


public class Runner {
    public static void main(String[] args) {
        Subject wire = new Subject("wire", STEEL, 0.03);
        System.out.println(wire);

        wire.setMaterial(COPPER);
        System.out.println("The wire mass is " + wire.getMass());
    }
}