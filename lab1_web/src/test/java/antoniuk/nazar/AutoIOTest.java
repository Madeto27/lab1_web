package antoniuk.nazar;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AutoIOTest {
    @Test
    public void autosExportAndImportTest() throws Exception {
        ArrayList<Auto> autos = new ArrayList<>();
        autos.add(new Auto("Dodge", 50));
        autos.add(new Auto("Ford", 40));

        AutoIO.exportAutos(autos, "test.json");
        ArrayList<Auto> testAutos = AutoIO.importAutos("test.json");

        assertEquals(autos, testAutos);
    }
}
