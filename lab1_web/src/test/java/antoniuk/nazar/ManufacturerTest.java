package antoniuk.nazar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ManufacturerTest {
    @Test
    public void produceCarQuantityTest(){
        Manufacturer manu = new Manufacturer("GM", "USA");
        manu.produceCar("Dodge", 10);
        assertEquals(1, manu.getCarsProduced());
    }

    @Test
    public void produceCarInListTest(){
        Manufacturer manu = new Manufacturer("GM", "USA");
        manu.produceCar("Dodge", 10);

        Auto auto = new Auto("Dodge", 10);
        assertTrue(manu.getCars().contains(auto));
    }
}
