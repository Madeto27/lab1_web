package antoniuk.nazar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//input/output
public class AutoIO {

    public static void exportAutos(ArrayList<Auto> autos, String fileName) throws IOException {
        autos.sort(Comparator.comparing(Auto::getBrand));
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(fileName);
        gson.toJson(autos, fileWriter);
        fileWriter.close();
    }

    public static ArrayList<Auto> importAutos(String fileName) throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(fileName);
        ArrayList<Auto> autos = gson.fromJson(fileReader, new TypeToken<ArrayList<Auto>>(){}.getType());
        fileReader.close();
        return autos;
    }
}
