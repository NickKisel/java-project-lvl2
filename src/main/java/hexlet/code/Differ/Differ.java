package hexlet.code.Differ;

import hexlet.code.Formatter.Formatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String format, Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        Map<String, String> commonData = keys.stream()
                .collect(Collectors.toMap(k -> k, v -> {
                    if (data1.containsKey(v) && data2.containsKey(v)) {
                        if (String.valueOf(data1.get(v)).equals(String.valueOf(data2.get(v)))) {
                            return "unchanged";
                        } else if (!String.valueOf(data1.get(v)).equals(String.valueOf(data2.get(v)))) {
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
        return formatter.choiceFormatter(format, commonData, data1, data2);
    }
}
