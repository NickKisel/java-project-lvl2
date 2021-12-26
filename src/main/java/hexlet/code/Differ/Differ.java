package hexlet.code.Differ;

import hexlet.code.Formatter.Formatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String format, Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> newData1 = convertData(data1);
        Map<String, String> newData2 = convertData(data2);
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        Map<String, String> commonData = keys.stream()
                .collect(Collectors.toMap(k -> k, v -> {
                    if (newData1.containsKey(v) && newData2.containsKey(v)) {
                        if (newData1.get(v).equals(newData2.get(v))) {
                            return "unchanged";
                        } else if (!newData1.get(v).equals(newData2.get(v))) {
                            return "changed";
                        }
                    } else if (!newData2.containsKey(v) && newData1.containsKey(v)) {
                        return "deleted";
                    } else if (!newData1.containsKey(v) && newData2.containsKey(v)) {
                        return "added";
                    }
                    return null; }, (k1, k2) -> k1, LinkedHashMap::new));
        Formatter formatter = new Formatter();
        return formatter.choiceFormatter(format, commonData, newData1, newData2);
    }

    public static Map<String, String> convertData(Map<String, Object> data) {
        return data.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));
    }
}
