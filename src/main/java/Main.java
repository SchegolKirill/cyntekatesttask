public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader("src/main/resources/input.txt");
        Utils utils = new Utils(reader);
        Writer writer = new Writer("src/main/resources/output.txt");

        reader.readFile();
        utils.sortValues();
        writer.writeFile(utils.getMap());
    }
}
