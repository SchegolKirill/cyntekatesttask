import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UtilsTest extends TestCase {
    private Map<String, String> map = new LinkedHashMap<>();
    private List<String> values = new ArrayList<>();
    private Reader reader;
    private Utils utils;

    @Test
    public void testSortValues(){
        reader = new Reader("src/test/resources/input.txt");
        reader.readFile();
        utils = new Utils(reader);
        map.put("гвоздь", "?");
        map.put("шуруп", "шуруп 3х1.5");
        map.put("краска синяя", "краска");
        map.put("ведро для воды", "корыто для воды");
        values.add("?");
        values.add("шуруп 3х1.5");
        values.add("краска");
        values.add("корыто для воды");

        utils.sortValues();

        assertEquals(utils.getMap(), map);
        assertEquals(utils.getValues(), values);
    }

    @Test
    public void testIsDigit(){
        assertTrue(Utils.isDigit("5"));
        assertFalse(Utils.isDigit("string"));
    }
}
