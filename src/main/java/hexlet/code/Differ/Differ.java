package hexlet.code.Differ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<String> result = new ArrayList<>();
        String keyValueDelimiter = ": ";
        String positiveSign = "  + ";
        String negativeSign = "  - ";
        String neutralSign = "    ";
        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.add(neutralSign + key + keyValueDelimiter + data1.get(key));
                }
                if (!data1.get(key).equals(data2.get(key))) {
                    result.add(negativeSign + key + keyValueDelimiter + data1.get(key));
                    result.add(positiveSign + key + keyValueDelimiter + data2.get(key));
                }
            }
            if (!data2.containsKey(key) && data1.containsKey(key)) {
                result.add(negativeSign + key + keyValueDelimiter + data1.get(key));
            }
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.add(positiveSign + key + keyValueDelimiter + data2.get(key));
            }
        }
        result.add(0, "{");
        result.add(result.size(), "}");
        String sResult = String.join("\n", result);
        return sResult;
    }
}
