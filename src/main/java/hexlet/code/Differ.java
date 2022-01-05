package hexlet.code;

import hexlet.code.Formatter.Formatter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        String fileContent1 = Files.readString(Paths.get(filepath1));
        String fileContent2 = Files.readString(Paths.get(filepath2));

        Parser parser = new Parser();
        Map<String, Object> data1 = parser.getData(fileContent1, getExtension(filepath1));
        Map<String, Object> data2 = parser.getData(fileContent2, getExtension(filepath2));

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        Map<String, String> commonData = keys.stream()
                .collect(Collectors.toMap(k -> k, v -> {
                    if (data1.containsKey(v) && data2.containsKey(v)) {
                        if (data1.get(v) != null && data2.get(v) != null && data1.get(v).equals(data2.get(v))
                                || data1.get(v) == data2.get(v)) {
                            return "unchanged";
                        } else if (data1.get(v) != null && data2.get(v) != null && !data1.get(v).equals(data2.get(v))
                                || data1.get(v) != data2.get(v)) {
                            return "changed";
                        }
                    } else if (!data2.containsKey(v) && data1.containsKey(v)) {
                        return "deleted";
                    } else if (!data1.containsKey(v) && data2.containsKey(v)) {
                        return "added";
                    }
                    return null;
                }, (k1, k2) -> k1, LinkedHashMap::new));
        Formatter formatter = new Formatter();
        return formatter.choiceFormatter(formatName, commonData, data1, data2);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getExtension(String filepath) {
        int i = filepath.lastIndexOf(".");
        return filepath.substring(i);
    }
}
