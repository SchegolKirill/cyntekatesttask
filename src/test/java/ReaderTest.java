import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest extends TestCase {
    private String path;
    private Reader reader;
    private List<String> lines1 = new ArrayList<>();
    private List<String> lines2 = new ArrayList<>();


    @Test
    public void testReadFile() {
        lines1.add("гвоздь");
        lines1.add("шуруп");
        lines1.add("краска синяя");
        lines1.add("ведро для воды");
        lines2.add("краска");
        lines2.add("корыто для воды");
        lines2.add("шуруп 3х1.5");

        path = "src/test/resources/input.txt";
        reader = new Reader(path);
        reader.readFile();

        assertEquals(lines1, reader.getLines1());
        assertEquals(lines2, reader.getLines2());
    }
}
