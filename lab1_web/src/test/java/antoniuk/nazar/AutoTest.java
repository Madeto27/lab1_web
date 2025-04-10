package antoniuk.nazar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AutoTest {
    @Test
    public void rideTest(){
        Auto auto = new Auto("Ford", 10);
        auto.ride(10);  
        assertEquals(5, auto.getFuelLevel());
    }

    @Test
    public void refuelFullTest() {
        Auto auto = new Auto("Ford", 10);
        auto.ride(10);
        auto.refuel(5);
        assertEquals(10, auto.getFuelLevel());
    }

    @Test
    public void refuelNegativeTest() {
        Auto auto = new Auto("Ford", 10);
        auto.ride(10);
        auto.refuel(-1);
        assertEquals(5, auto.getFuelLevel());
    }

    @Test
    public void refuelZeroTest() {
        Auto auto = new Auto("Ford", 10);
        auto.ride(10);
        auto.refuel(0);
        assertEquals(5, auto.getFuelLevel());
    }

    @Test
    public void refuelOverTest() {
        Auto auto = new Auto("Ford", 10);
        auto.ride(10);
        auto.refuel(10);
        assertEquals(10, auto.getFuelLevel());
    }
}
