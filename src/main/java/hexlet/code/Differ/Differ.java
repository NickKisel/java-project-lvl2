package hexlet.code.Differ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> newData1 = data1.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));
        Map<String, String> newData2 = data2.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<String> result = new ArrayList<>();
        String keyValueDelimiter = ": ";
        String positiveSign = "  + ";
        String negativeSign = "  - ";
        String neutralSign = "    ";
        for (String key : keys) {
            if (newData1.containsKey(key) && newData2.containsKey(key)) {
                if (newData1.get(key).equals(newData2.get(key))) {
                    result.add(neutralSign + key + keyValueDelimiter + newData1.get(key));
                } else if (!newData1.get(key).equals(newData2.get(key))) {
                    result.add(negativeSign + key + keyValueDelimiter + newData1.get(key));
                    result.add(positiveSign + key + keyValueDelimiter + newData2.get(key));
                }
            } else if (!newData2.containsKey(key) && newData1.containsKey(key)) {
                result.add(negativeSign + key + keyValueDelimiter + newData1.get(key));
            } else if (!newData1.containsKey(key) && newData2.containsKey(key)) {
                result.add(positiveSign + key + keyValueDelimiter + newData2.get(key));
            }
        }
        result.add(0, "{");
        result.add(result.size(), "}");
        return String.join("\n", result);
    }
}
