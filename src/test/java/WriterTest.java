import junit.framework.TestCase;

public class WriterTest extends TestCase {
    Writer writer;
    Reader reader;
    Utils utils;

    public void testWriteFile() {
        String pathInput = "src/test/resources/input.txt";
        String pathOutput = "src/test/resources/output.txt";
        reader = new Reader(pathInput);
        reader.readFile();
        utils = new Utils(reader);
        utils.sortValues();
        writer = new Writer(pathOutput);
        writer.writeFile(utils.getMap());
    }
}
