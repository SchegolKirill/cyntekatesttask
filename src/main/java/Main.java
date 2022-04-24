
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input.txt");
        File outputFile = new File("src/main/resources/output.txt");
        String line = "";
        List<String> lines1 = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {

                if(isDigit(line)){
                    lines1 = lines2;
                    lines2 = new ArrayList<>();
                    continue;
                }
                lines2.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> map = new LinkedHashMap<>();
        List<String> values = new ArrayList<>();

        for(int i = 0; i < lines1.size(); i++) {
            String[] lineOfWords1 = lines1.get(i).split(" ");
            for(int j = 0; j < lineOfWords1.length; j++) {
                for(int k = 0; k < lines2.size(); k++) {
                    if(lines2.get(k).toLowerCase(Locale.ROOT).contains(lineOfWords1[j].toLowerCase(Locale.ROOT))){
                        map.put(lines1.get(i), lines2.get(k));
                        break;
                    }
                }
            }
            if(!map.containsKey(lines1.get(i))){
                map.put(lines1.get(i), "?");
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

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            for(Map.Entry<String, String> entry : map.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
