package antoniuk.nazar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AutoparkTest {
    @Test
    public void addVehicleTest(){
        Autopark autopark = Autopark.getAutopark(10, "Maidan St.");
        Auto auto = new Auto("Dodge", 10);
        autopark.addVehicle(auto);
        assertTrue(autopark.getCars().contains(auto));
    }

    @Test
    public void filledNormalTest(){
        Autopark autopark = Autopark.getAutopark(10, "Maidan St.");
        Auto auto = new Auto("Dodge", 10);
        autopark.addVehicle(auto);
        assertEquals(0.1, autopark.getFilled());
    }

    @Test
    public void filledMaxTest(){
        Autopark autopark = Autopark.getAutopark(1, "Maidan St.");
        Auto auto1 = new Auto("Dodge", 10);
        Auto auto2 = new Auto("Dodge", 10);
        autopark.addVehicle(auto1);
        autopark.addVehicle(auto2);
        assertEquals(1, autopark.getFilled());
    }
}
