import java.util.*;

public class Utils {
    private Map<String, String> map = new LinkedHashMap<>();
    private List<String> values = new ArrayList<>();
    private Reader reader;

    public Utils(Reader reader) {
        this.reader = reader;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public List<String> getValues() {
        return values;
    }

    public void sortValues() {
        List<String> lines1 = reader.getLines1();
        List<String> lines2 = reader.getLines2();

        for (String line1 : lines1) {
            String[] lineOfWords1 = line1.split(" ");
            for (String word : lineOfWords1) {
                for (String line2 : lines2) {
                    if (line2.toLowerCase(Locale.ROOT).contains(word.toLowerCase(Locale.ROOT))) {
                        map.put(line1, line2);
                        break;
                    }
                }
            }
            if (!map.containsKey(line1)) {
                map.put(line1, "?");
            }
        }
        for(Map.Entry<String, String> entry : map.entrySet()) {
            values.add(entry.getValue());
        }
        for(String str : lines2) {
            if(!values.contains(str)){
                for(Map.Entry<String, String> entry : map.entrySet()){
                    if(entry.getValue().equals("?")){
                        map.put(entry.getKey(), str);
                    }else {
                        map.put(str, "?");
                    }
                }
            }
        }
    }

    public static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
