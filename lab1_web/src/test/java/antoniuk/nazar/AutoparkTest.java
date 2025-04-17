package antoniuk.nazar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoparkTest {
    @BeforeEach
    public void resetAutopark() {
        Autopark.reset(); // Clears all cars, resets state
    }

    @Test
    public void parkVehicleTest(){
        Autopark autopark = Autopark.getAutopark(10, "Maidan St.");
        Auto auto = new Auto("Dodge", 10);
        autopark.parkVehicle(auto);
        assertTrue(autopark.getParkedAutos().contains(auto));
    }

    @Test
    public void filledNormalTest(){
        Autopark autopark = Autopark.getAutopark(10, "Maidan St.");
        Auto auto = new Auto("Dodge", 10);
        autopark.parkVehicle(auto);
        assertEquals(0.1, autopark.getFilled());
    }

    @Test
    public void filledMaxTest(){
        Autopark autopark = Autopark.getAutopark(1, "Maidan St.");
        Auto auto1 = new Auto("Dodge", 10);
        Auto auto2 = new Auto("Dodge", 10);
        autopark.parkVehicle(auto1);
        autopark.parkVehicle(auto2);
        assertEquals(1, autopark.getFilled());
    }
}
