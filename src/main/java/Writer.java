import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    private String path;

    public Writer(String path) {
        this.path = path;
    }

    public void writeFile(Map<String, String> map) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for(Map.Entry<String, String> entry : map.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
