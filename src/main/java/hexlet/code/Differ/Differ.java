package hexlet.code.Differ;

import java.util.*;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        List<String> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key) && data1.get(key).equals(data2.get(key))) {
                result.add("   " + key + ": " + data1.get(key));
            }
            if (!data2.containsKey(key) && data1.containsKey(key)) {
                result.add(" - " + key + ": " + data1.get(key));
            }
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.add(" + " + key + ": " + data2.get(key));
            }
            if (data1.containsKey(key) && data2.containsKey(key) && !data1.get(key).equals(data2.get(key))) {
                result.add(" - " + key + ": " + data1.get(key));
                result.add(" + " + key + ": " + data2.get(key));
            }
        }
        result.add(0, "{");
        result.add(result.size(), "}");
        String result1 = result.stream()
                .collect(Collectors.joining("\n"));
        System.out.println(result1);
        return result1;
    }
}